package uz.smartmuslim.chefchatdemoversion.presentation.ui.screen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.smartmuslim.chefchatdemoversion.data.response.FoodResponse
import uz.smartmuslim.chefchatdemoversion.R
import uz.smartmuslim.chefchatdemoversion.SecondActivity
import uz.smartmuslim.chefchatdemoversion.databinding.ScreenBookmarkBinding
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.AdapterNewRecipe

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
            findNavController().navigate(R.id.screenRecipe)
        }
    }


    private fun initList(): List<FoodResponse> {

        return listOf(
            FoodResponse(
                "1",
                "Quyiltirilgan sutga ega tez tayyor bo’ladigan pirojniylar",
                "https://zira.uz/wp-content/uploads/2021/04/pirozhenoe-1.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "5",
                100,
                200,
                "https://images.unsplash.com/photo-1556911220-e15b29be8c8f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG9tZSUyMGNvb2tpbmd8ZW58MHx8MHx8&w=1000&q=80"
            ),

            FoodResponse(
                "2",
                "Frikadelka va mayda makaronli sho’rva",
                "https://zira.uz/wp-content/uploads/2019/12/sup-s-frikadelkami-4.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "5",
                1050,
                2030,
                "https://st.depositphotos.com/1570716/1697/i/950/depositphotos_16978587-stock-photo-male-chef-cooking.jpg"
            ),
            FoodResponse(
                "3",
                "Rezavor mevalar mavsumi: malina va qulupnaydan nimalar tayyorlasa bo’ladi.",
                "https://zira.uz/wp-content/uploads/2019/06/drezdenskiy-tort-5.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "5",
                1050,
                2030,
                "https://img.poki.com/cdn-cgi/image/quality=78,width=314,height=314,fit=cover,f=auto/363859cddea918a7307d3c14a0676787.png"
            ),
            FoodResponse(
                "4",
                "Qozon kabob",
                "https://zira.uz/wp-content/uploads/2021/05/kazan-kebab-coca-cola-2.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "5",
                100,
                220,
                "https://thumbs.dreamstime.com/z/young-man-cooking-27697797.jpg"
            ),
            FoodResponse(
                "5",
                "Manti «Atirgul»",
                "https://zira.uz/wp-content/uploads/2021/05/manty-rozochka-coca-cola-4.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "5",
                1030,
                2240,
                "https://img3.stockfresh.com/files/m/mythja/m/10/1845499_stock-photo-cooking-ingredients.jpg"
            )
        )
    }

}