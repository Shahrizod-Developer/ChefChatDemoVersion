package uz.smartmuslim.chefchatdemoversion.presentation.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import uz.smartmuslim.chefchatdemo.data.response.FoodResponse
import uz.smartmuslim.chefchatdemoversion.R
import uz.smartmuslim.chefchatdemoversion.data.other.Data
import uz.smartmuslim.chefchatdemoversion.data.other.Photo
import uz.smartmuslim.chefchatdemoversion.data.response.IngredientResponse
import uz.smartmuslim.chefchatdemoversion.data.response.PreparationResponse
import uz.smartmuslim.chefchatdemoversion.data.response.ProductResponse
import uz.smartmuslim.chefchatdemoversion.databinding.DialogAddProductBinding
import uz.smartmuslim.chefchatdemoversion.databinding.ScreenAddBinding
import uz.smartmuslim.chefchatdemoversion.databinding.ScreenCartBinding
import uz.smartmuslim.chefchatdemoversion.presentation.adapter.*
import uz.smartmuslim.chefchatdemoversion.presentation.ui.viewmodel.ScreenAddViewModel
import uz.smartmuslim.chefchatdemoversion.presentation.ui.viewmodel.ScreenCartViewModel
import uz.smartmuslim.chefchatdemoversion.presentation.utils.InfoClass

class ScreenCart : Fragment(R.layout.screen_cart) {

    private val binding by viewBinding(ScreenCartBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.rv.adapter = AdapterCart(requireContext(), initProductList())
        { it, pos ->

            Toast.makeText(requireContext(), "salom", Toast.LENGTH_SHORT).show()
        }

    }


    private fun initProductList(): List<ProductResponse> {
        var list = listOf(
            ProductResponse(
                1,
                "Shakar",
                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "500",
                "gr"),
            ProductResponse(
                1,
                "Shakar",
                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "500",
                "gr"),
            ProductResponse(
                1,
                "Shakar",
                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "500",
                "gr"),
            ProductResponse(
                1,
                "Shakar",
                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "500",
                "gr"),
            ProductResponse(
                1,
                "Shakar",
                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "500",
                "gr"),
            ProductResponse(
                1,
                "Shakar",
                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "500",
                "gr"),
            ProductResponse(
                1,
                "Shakar",
                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "500",
                "gr"),
            ProductResponse(
                1,
                "Shakar",
                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "500",
                "gr"),
            ProductResponse(
                1,
                "Shakar",
                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "500",
                "gr"),
            ProductResponse(
                1,
                "Shakar",
                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "500",
                "gr"),
            ProductResponse(
                1,
                "Shakar",
                "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg",
                "500",
                "gr")

        )

        return list
    }
}