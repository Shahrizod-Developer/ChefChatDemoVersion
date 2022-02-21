package uz.smartmuslim.chefchatdemoversion.presentation.ui.screen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.smartmuslim.chefchatdemo.data.response.FoodResponse
import uz.smartmuslim.chefchatdemoversion.R
import uz.smartmuslim.chefchatdemoversion.SecondActivity
import uz.smartmuslim.chefchatdemoversion.databinding.ScreenBookmarkBinding
import uz.smartmuslim.chefchatdemoversion.databinding.ScreenCartBinding
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.AdapterArticle
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.AdapterNewRecipe
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.FoodSliderAdapter
import uz.smartmuslim.chefchatdemoversion.presentation.ui.viewmodel.ScreenBookmarkViewModel
import uz.smartmuslim.chefchatdemoversion.presentation.ui.viewmodel.ScreenCartViewModel
import uz.smartmuslim.chefchatdemoversion.presentation.utils.DepthPageTransformer

class ScreenBookmark : Fragment(R.layout.screen_bookmark) {

    private val binding by viewBinding(ScreenBookmarkBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setOtherRecipeAdapter()
    }

    private fun setOtherRecipeAdapter() {
        binding.rv.adapter = AdapterNewRecipe(
            requireContext(),
            initList() as List<FoodResponse>
        ) { it, pos ->
            startActivity(Intent(requireContext(), SecondActivity::class.java))
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