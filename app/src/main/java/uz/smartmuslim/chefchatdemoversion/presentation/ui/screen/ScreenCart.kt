package uz.smartmuslim.chefchatdemoversion.presentation.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import uz.smartmuslim.chefchatdemoversion.R
import uz.smartmuslim.chefchatdemoversion.data.other.Ingredients
import uz.smartmuslim.chefchatdemoversion.data.response.ProductResponse
import uz.smartmuslim.chefchatdemoversion.databinding.DialogAddProductBinding
import uz.smartmuslim.chefchatdemoversion.databinding.ScreenCartBinding
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.*

class ScreenCart : Fragment(R.layout.screen_cart) {

    private val binding by viewBinding(ScreenCartBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.rv.adapter = AdapterCart(requireContext(), Ingredients.items)
        { it, pos ->

            Toast.makeText(requireContext(), it.name, Toast.LENGTH_SHORT).show()
        }
        binding.add.setOnClickListener {
            showBottomDialog()
        }
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
}