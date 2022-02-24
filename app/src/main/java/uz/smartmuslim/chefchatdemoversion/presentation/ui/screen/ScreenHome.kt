package uz.smartmuslim.chefchatdemoversion.presentation.ui.screen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import uz.smartmuslim.chefchatdemoversion.R
import uz.smartmuslim.chefchatdemoversion.SecondActivity
import uz.smartmuslim.chefchatdemoversion.data.other.*
import uz.smartmuslim.chefchatdemoversion.data.response.*
import uz.smartmuslim.chefchatdemoversion.databinding.DialogAddProductBinding
import uz.smartmuslim.chefchatdemoversion.databinding.DialogBottomMenuBinding
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.AdapterAddProduct
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.AdapterArticle
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.AdapterNewRecipe
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.FoodSliderAdapter
import uz.smartmuslim.chefchatdemoversion.presentation.utils.DepthPageTransformer
import kotlin.collections.ArrayList


class ScreenHome : Fragment(R.layout.screen_home) {

    private val binding by viewBinding(uz.smartmuslim.chefchatdemoversion.databinding.ScreenHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = FoodSliderAdapter(requireContext(), initList())
        binding.viewpager.adapter = adapter
        binding.viewpager.setPageTransformer(true, DepthPageTransformer())

        binding.menuButton.setOnClickListener {
            showBottomDialog()
        }
        binding.chatButton.setOnClickListener {
            Toast.makeText(requireContext(), "Chatlar hozircha mavjud emas", Toast.LENGTH_SHORT)
                .show()
        }
        binding.notificationButton.setOnClickListener {
            Toast.makeText(requireContext(), "Bildirishnomalar yo'q", Toast.LENGTH_SHORT).show()
        }
        setNewRecipeAdapter()
        setSweetsAdapter()
        setArticlesAdapter()
        setOtherRecipeAdapter()
    }
    private fun showBottomDialog() {

        val dialog = BottomSheetDialog(requireContext())
        val dialogView = DialogBottomMenuBinding.inflate(LayoutInflater.from(requireContext()), null, false)


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


    private fun setOtherRecipeAdapter() {
        binding.rvOtherRecipes.adapter = AdapterNewRecipe(
            requireContext(),
            initList() as List<FoodResponse>
        ) { it, pos ->
            val navBuilder = NavOptions.Builder()
            navBuilder.setEnterAnim(R.anim.enter_from_right)
                .setExitAnim(R.anim.exit_to_left)
                .setPopEnterAnim(R.anim.enter_from_left)
                .setPopExitAnim(R.anim.exit_to_right)
            NavHostFragment.findNavController(this@ScreenHome)
                .navigate(R.id.screenRecipe, null, navBuilder.build())
        }
    }
    private fun setArticlesAdapter() {
        binding.rvArticles.adapter = AdapterArticle(
            requireContext(),
            initListArticle() as List<FoodResponse>
        ) { it, pos ->

            val navBuilder = NavOptions.Builder()
            navBuilder.setEnterAnim(R.anim.enter_from_right)
                .setExitAnim(R.anim.exit_to_left)
                .setPopEnterAnim(R.anim.enter_from_left)
                .setPopExitAnim(R.anim.exit_to_right)
            NavHostFragment.findNavController(this@ScreenHome)
                .navigate(R.id.action_screen_home_to_screenArticle, null, navBuilder.build())
        }
    }

    private fun setSweetsAdapter() {
        binding.rvSweets.adapter = AdapterNewRecipe(
            requireContext(),
            initListSweets() as List<FoodResponse>
        ) { it, pos ->
            val navBuilder = NavOptions.Builder()
            navBuilder.setEnterAnim(R.anim.enter_from_right)
                .setExitAnim(R.anim.exit_to_left)
                .setPopEnterAnim(R.anim.enter_from_left)
                .setPopExitAnim(R.anim.exit_to_right)
            NavHostFragment.findNavController(this@ScreenHome)
                .navigate(R.id.screenRecipe, null, navBuilder.build())
        }
    }

    private fun setNewRecipeAdapter() {
        binding.rv.adapter = AdapterNewRecipe(
            requireContext(),
            initList() as List<FoodResponse>
        ) { it, pos ->
            val navBuilder = NavOptions.Builder()
            navBuilder.setEnterAnim(R.anim.enter_from_right)
                .setExitAnim(R.anim.exit_to_left)
                .setPopEnterAnim(R.anim.enter_from_left)
                .setPopExitAnim(R.anim.exit_to_right)
            NavHostFragment.findNavController(this@ScreenHome)
                .navigate(R.id.screenRecipe, null, navBuilder.build())
        }
    }

    private fun initListArticle(): List<FoodResponse> {

        return listOf(
            FoodResponse(
                "1",
                "Iste’mol qilish qulay bo’lgan ovqatlar: qanday va nima uchun kerak?",
                "https://zira.uz/wp-content/uploads/2018/01/r817-final-4x3.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "5",
                100,
                200,
                "https://www.ice.edu/sites/default/files/styles/width_450/public/content/gallery-item/image/student.jpg?itok=L4-oJvU1"
            ),

            FoodResponse(
                "2",
                "Bozorlardagi asosiy oziq-ovqat mahsulotlari narxi e’lon qilindi",
                "https://storage.kun.uz/source/thumbnails/_medium/7/HSYF-iMp_3zxAEgWwPNg3daquR_ICtzu_medium.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "5",
                1050,
                2030,
                "https://st.depositphotos.com/1570716/1697/i/950/depositphotos_16978587-stock-photo-male-chef-cooking.jpg",
            ),
            FoodResponse(
                "3",
                "TikTok oziq-ovqat yetkazib berish xizmatini yoʻlga qoʻyadi. Taomlar retsepti uchun blogerlarga ulush beriladi",
                "https://www.spot.uz/media/img/2021/12/MKb5Je16397511686006_l.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "5",
                1050,
                2030,
                "https://img.poki.com/cdn-cgi/image/quality=78,width=314,height=314,fit=cover,f=auto/363859cddea918a7307d3c14a0676787.png",
            )
        )
    }
    private fun initListSweets(): List<FoodResponse> {

        return listOf(
            FoodResponse(
                "1",
                "Qulupnayli keks",
                "https://zira.uz/wp-content/uploads/2018/05/keks-s-klubnikoy-2.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "5",
                100,
                200,
                "https://www.ice.edu/sites/default/files/styles/width_450/public/content/gallery-item/image/student.jpg?itok=L4-oJvU1"
            ),

            FoodResponse(
                "2",
                "Qaynatilgan quyultirilgan sutdan tayyorlangan yong’oqli pirog",
                "https://zira.uz/wp-content/uploads/2020/09/pirog_s_varenoy_sgushhenkoy_i_orekhami_2.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "5",
                1050,
                2030,
                "https://st.depositphotos.com/1570716/1697/i/950/depositphotos_16978587-stock-photo-male-chef-cooking.jpg",
            ),
            FoodResponse(
                "3",
                "Olmaga ega tvorogli pirog",
                "https://proc.uz/storage/stats/July2021/tvorozhnyy-pirog-s-yablokami.jpg",
                "android.resource://" + requireActivity().packageName + "/" + R.raw.video_file,
                "5",
                1050,
                2030,
                "https://img.poki.com/cdn-cgi/image/quality=78,width=314,height=314,fit=cover,f=auto/363859cddea918a7307d3c14a0676787.png",
            )
        )
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