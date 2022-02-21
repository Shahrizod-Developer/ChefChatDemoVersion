package uz.smartmuslim.chefchatdemoversion.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.smartmuslim.chefchatdemoversion.data.response.ProductResponse
import uz.smartmuslim.chefchatdemoversion.databinding.ItemIngredientBinding
import uz.smartmuslim.chefchatdemoversion.databinding.ItemProductBinding


class AdapterAddProduct(
    private val context: Context,
    private val list: List<ProductResponse>,
    val onClick: (ingredient: ProductResponse, pos: Int) -> Unit
) : RecyclerView.Adapter<AdapterAddProduct.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(ingredient: ProductResponse, pos: Int) {

            Glide.with(context).load(ingredient.image).into(binding.image)
            binding.name.text = ingredient.name

            itemView.setOnClickListener {
                onClick(ingredient, pos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}