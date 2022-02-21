package uz.smartmuslim.chefchatdemoversion.presentation.ui.screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.smartmuslim.chefchatdemo.data.response.FoodResponse
import uz.smartmuslim.chefchatdemoversion.R
import uz.smartmuslim.chefchatdemoversion.SecondActivity
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.AdapterArticle
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.AdapterNewRecipe
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.FoodSliderAdapter
import uz.smartmuslim.chefchatdemoversion.presentation.utils.DepthPageTransformer


class ScreenHome : Fragment(R.layout.screen_home) {

    private val binding by viewBinding(uz.smartmuslim.chefchatdemoversion.databinding.ScreenHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = FoodSliderAdapter(requireContext(), initList())
        binding.viewpager.adapter = adapter
        binding.viewpager.setPageTransformer(true, DepthPageTransformer())

        setNewRecipeAdapter()
        setSweetsAdapter()
        setArticlesAdapter()
        setOtherRecipeAdapter()
    }

    private fun setOtherRecipeAdapter() {
        binding.rvOtherRecipes.adapter = AdapterNewRecipe(
            requireContext(),
            initList() as List<FoodResponse>
        ) { it, pos ->
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }
    }

    private fun setArticlesAdapter() {
        binding.rvArticles.adapter = AdapterArticle(
            requireContext(),
            initList() as List<FoodResponse>
        ) { it, pos ->
            Toast.makeText(requireContext(), it.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setSweetsAdapter() {
        binding.rvSweets.adapter = AdapterNewRecipe(
            requireContext(),
            initList() as List<FoodResponse>
        ) { it, pos ->
            Toast.makeText(requireContext(), it.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setNewRecipeAdapter() {
        binding.rv.adapter = AdapterNewRecipe(
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
}