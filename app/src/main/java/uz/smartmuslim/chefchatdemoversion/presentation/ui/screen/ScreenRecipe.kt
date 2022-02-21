package uz.smartmuslim.chefchatdemoversion.presentation.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.appbar.AppBarLayout
import uz.smartmuslim.chefchatdemo.data.response.FoodResponse
import uz.smartmuslim.chefchatdemoversion.R
import uz.smartmuslim.chefchatdemoversion.data.other.Data
import uz.smartmuslim.chefchatdemoversion.data.other.Photo
import uz.smartmuslim.chefchatdemoversion.data.response.CommentResponse
import uz.smartmuslim.chefchatdemoversion.data.response.IngredientResponse
import uz.smartmuslim.chefchatdemoversion.data.response.PreparationResponse
import uz.smartmuslim.chefchatdemoversion.databinding.ScreenRecipeBinding
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.*
import uz.smartmuslim.chefchatdemoversion.presentation.utils.InfoClass

class ScreenRecipe : Fragment(R.layout.screen_recipe) {

    private val binding by viewBinding(ScreenRecipeBinding::bind)
    private var itemsData = ArrayList<PreparationResponse>()
    private var expandedSize = ArrayList<Int>()

    private lateinit var adapter: AdapterPreparation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = AdapterPreparation(requireContext(), itemsData, expandedSize)
        val llm = LinearLayoutManager(requireContext())

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.appBarLayout.addOnOffsetChangedListener(object : InfoClass() {
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?) {
                when (state) {
                    State.COLLAPSED -> {
                        binding.name.visibility = View.INVISIBLE
                        binding.title.visibility = View.VISIBLE
                    }
                    State.IDLE -> {
                        binding.name.visibility = View.VISIBLE
                        binding.title.visibility = View.INVISIBLE
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

        binding.rv.adapter = AdapterProduct(requireContext(), productList())
        { it, pos ->

            Toast.makeText(requireContext(), "salom", Toast.LENGTH_SHORT).show()
        }
        setPhotosAdapter()
        setCommentAdapter()
        setLikeAdapter()
    }


    private fun setPhotosAdapter() {
        binding.rvPhotos.adapter = AdapterPhotos(
            requireContext(),
            initListPhotos() as List<Photo>
        ) { it, pos ->
            Toast.makeText(requireContext(), "Rasm", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setCommentAdapter() {
        binding.rvComment.adapter = AdapterComment(
            requireContext(),
            initListComment() as List<CommentResponse>
        ) { it, pos ->
            Toast.makeText(requireContext(), "Rasm", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initListComment(): List<CommentResponse> {
        return listOf(
            CommentResponse(
                "1",
                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "Shahnoza Qosimova",
                "19.02.2022",
                "18:32",
                39,
                "Assalomu alaykum hammaga bu ovqat juda zo'r",
            ),
        )
    }

    private fun initListPhotos(): List<Photo> {
        return listOf(
            Photo("https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg"),
            Photo("https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg"),
            Photo("https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg")
        )
    }

    private fun productList(): List<IngredientResponse> {

        return listOf(
            IngredientResponse(

                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "150 gr un"

            ),
            IngredientResponse(

                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "150 gr un"

            ),
            IngredientResponse(

                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "150 gr un"

            )
        )
    }

    private fun setLikeAdapter() {
        binding.rvLike.adapter = AdapterNewRecipe(
            requireContext(),
            initList() as List<FoodResponse>
        ) { it, pos ->
            Toast.makeText(requireContext(), it.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initList(): List<FoodResponse> {

        return listOf(
            FoodResponse(
                "1",
                "Osh",
                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "2",
                100,
                200,
                "https://storge.pic2.me/c/1360x800/506/5a634028e2f0a.jpg"
            ),
            FoodResponse(
                "1",
                "Osh",
                "https://storge.pic2.me/c/1360x800/506/5a634028e2f0a.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "2",
                100,
                200,
                "https://storge.pic2.me/c/1360x800/506/5a634028e2f0a.jpg"
            ),
            FoodResponse(
                "1",
                "Osh",
                "https://storge.pic2.me/c/1360x800/506/5a634028e2f0a.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "2",
                100,
                200,
                "https://storge.pic2.me/c/1360x800/506/5a634028e2f0a.jpg"
            )
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