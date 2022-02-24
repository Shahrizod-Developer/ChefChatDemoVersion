package uz.smartmuslim.chefchatdemoversion.presentation.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import uz.smartmuslim.chefchatdemoversion.R
import uz.smartmuslim.chefchatdemoversion.data.other.Data
import uz.smartmuslim.chefchatdemoversion.data.other.Ingredients
import uz.smartmuslim.chefchatdemoversion.data.other.Photo
import uz.smartmuslim.chefchatdemoversion.data.response.ProductResponse
import uz.smartmuslim.chefchatdemoversion.data.response.PreparationResponse
import uz.smartmuslim.chefchatdemoversion.databinding.DialogAddProductBinding
import uz.smartmuslim.chefchatdemoversion.databinding.ScreenAddBinding
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.*
import uz.smartmuslim.chefchatdemoversion.presentation.utils.InfoClass

class ScreenAdd : Fragment(R.layout.screen_add) {

    private val binding by viewBinding(ScreenAddBinding::bind)
    private var itemsData = ArrayList<PreparationResponse>()
    private var expandedSize = ArrayList<Int>()

    private lateinit var adapter: AdapterPreparation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        adapter = AdapterPreparation(requireContext(), itemsData, expandedSize)
        val llm = LinearLayoutManager(requireContext())

        binding.add.setOnClickListener {
          showBottomDialog()
        }
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.appBarLayout.addOnOffsetChangedListener(object : InfoClass() {
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?) {
                when (state) {
                    State.COLLAPSED -> {
                        binding.ln.visibility = View.INVISIBLE
                    }
                    State.IDLE -> {
                        binding.ln.visibility = View.VISIBLE
                    }
                    else -> {

                    }
                }
            }

        })

        binding.rvStep.setHasFixedSize(true)
        binding.rvStep.layoutManager = llm
        getData()
        binding.rvStep.adapter = adapter

        binding.rvProduct.adapter = AdapterIngredientAdd(requireContext(), Ingredients.items as ArrayList<ProductResponse>)
        { it, pos ->

            Toast.makeText(requireContext(), "salom", Toast.LENGTH_SHORT).show()
        }
        setPhotosAdapter()
    }

    private fun showBottomDialog() {

        val dialog = BottomSheetDialog(requireContext())
        val dialogView = DialogAddProductBinding.inflate(LayoutInflater.from(requireContext()), null, false)

        dialogView.rvProduct.adapter = AdapterAddProduct(requireContext(), Ingredients.items)
        {
            it, pos ->
            Toast.makeText(requireContext(), "Salom", Toast.LENGTH_SHORT).show()
        }

        dialog.setOnShowListener { dia ->
            val bottomSheetDialog = dia as BottomSheetDialog
            val bottomSheetInternal: FrameLayout =
                bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet)!!
            bottomSheetInternal.setBackgroundResource(R.drawable.back_style_bottom_sheet)
        }

        dialog.setContentView(dialogView.root)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    private fun setPhotosAdapter() {
        binding.rvPhotos.adapter = AdapterPhotos(
            requireContext(),
            initListPhotos() as List<Photo>
        ) { it, pos ->
            Toast.makeText(requireContext(), "Rasm", Toast.LENGTH_SHORT).show()
        }
    }



    private fun initListPhotos(): List<Photo> {
        return listOf(
            Photo("https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg"),
            Photo("https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg"),
            Photo("https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg")
        )
    }

    private fun getData() {
        itemsData = ArrayList()
        itemsData = Data.items

        setCellSize()

        adapter.notifyDataSetChanged()
        adapter = AdapterPreparation(requireContext(), itemsData, expandedSize)
    }

    // Set the expanded view size to 0, because all expanded views are collapsed at the beginning
    private fun setCellSize() {
        expandedSize = ArrayList()
        for (i in 0 until itemsData.count()) {
            expandedSize.add(0)
        }
    }
}