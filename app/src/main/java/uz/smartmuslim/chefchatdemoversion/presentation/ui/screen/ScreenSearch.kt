package uz.smartmuslim.chefchatdemoversion.presentation.ui.screen

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import uz.smartmuslim.chefchatdemo.data.response.FoodResponse
import uz.smartmuslim.chefchatdemoversion.R
import uz.smartmuslim.chefchatdemoversion.databinding.ScreenSearchBinding
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.AdapterTab
import uz.smartmuslim.chefchatdemoversion.presentation.ui.viewmodel.ScreenSearchViewModel

class ScreenSearch : Fragment(R.layout.screen_search) {

    private val binding by viewBinding(ScreenSearchBinding::bind)
    private val viewModel: ScreenSearchViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.viewPager.adapter =
            AdapterTab(
                requireContext(),
                viewModel, initList()
            ).apply { setHasStableIds(true) }

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = viewModel.items[position]
        }.attach()

        binding.viewPager.apply {
            layoutDirection = View.LAYOUT_DIRECTION_LTR
            currentItem = 0
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