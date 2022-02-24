package uz.smartmuslim.chefchatdemoversion.presentation.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.appbar.AppBarLayout
import uz.smartmuslim.chefchatdemoversion.data.response.FoodResponse
import uz.smartmuslim.chefchatdemoversion.R
import uz.smartmuslim.chefchatdemoversion.data.other.*
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
                        binding.ln.visibility = View.INVISIBLE
                        binding.title.visibility = View.VISIBLE
                    }
                    State.IDLE -> {
                        binding.name.visibility = View.VISIBLE
                        binding.ln.visibility = View.VISIBLE
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
            Photo("https://i.ytimg.com/vi/ay9lLMGZjsg/mqdefault.jpg"),

            Photo("https://i.ytimg.com/vi/66rj1GmpmxQ/maxresdefault.jpg"),

            Photo("https://zira.uz/wp-content/uploads/2018/07/kovurma-lagman-14.jpg")
        )
    }

    private fun productList(): List<IngredientResponse> {

        return listOf(
            IngredientResponse(

                "http://on24.uz/image/cache/catalog/ALL%20Product/mol%20gush-500x500.jpg",
                "300 gram mol go'shti"

            ),
            IngredientResponse(

                "https://i2.wp.com/mir-ogorod.ru/wp-content/uploads/2017/08/lukzima-7-600x385.jpg",
                "150 gram piyoz "

            ),
            IngredientResponse(

                "https://a.domesticfutures.com/housework/urozhajnie-sorta-morkovi-15.webp",
                "100 gramm qizil sabzi"

            ),
            IngredientResponse(

                "https://img2.zakaz.uz/09.1632520416.ad72436478c_2021-09-25_Victoria/09.1632520416.SNCPSG10.obj.0.1.jpg.oe.jpg.pf.jpg.350nowm.jpg.350x.jpg",
                "150 gramm qizil bulg'or qalampiri"

            ),
            IngredientResponse(

                "https://img1.zakaz.uz/upload.version_1.0.a28dc50831b836c7978e6b8113257d17.350x350.jpeg",
                "150 gramm yashil bulg'or qalampiri"

            ),
            IngredientResponse(

                "https://gallaorolkaliyfosfat.uz/wp-content/uploads/2020/09/podkormka-tomatov-min-3bjtt5ssxd54vmmpna01z4.jpg",
                "350 gramm pomidor"

            ),
            IngredientResponse(

                "https://tushlar.ru/wp-content/uploads/2021/02/Tushda-tuxum-2.jpg",
                "2 ta tuxum"

            ),
            IngredientResponse(

                "https://i.ytimg.com/vi/UO6RlkySVZU/maxresdefault.jpg",
                "300 gramm lag'mon uchun lapsha"

            ),
            IngredientResponse(

                "https://fazo.tv/phaser/wp-content/uploads/2016/12/15-2-1024x633.jpg",
                "1,5 litr suv"

            ),
            IngredientResponse(

                "https://img02.flagma.uz/photo/tuz-eng-arzon-narxda-o-zbekiston-tuz-1762911_big.jpg",
                "ta'bga ko'ra tuz"

            ),
            IngredientResponse(

                "https://i0.wp.com/mingdavo.uz/wp-content/uploads/2020/04/7CelZBhKnfI.jpg?resize=750%2C375&ssl=1",
                "ta'bga ko'ra zira"

            ),
            IngredientResponse(

                "https://zamin.uz/uploads/posts/2018-04/1524414325_342.jpg",
                "qovurish uchun o'simlik yog'i"

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