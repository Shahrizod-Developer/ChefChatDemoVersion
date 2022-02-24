package uz.smartmuslim.chefchatdemoversion.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.smartmuslim.chefchatdemoversion.data.response.IngredientResponse
import uz.smartmuslim.chefchatdemoversion.data.response.ProductResponse
import uz.smartmuslim.chefchatdemoversion.databinding.ItemIngredientBinding

class AdapterProduct(
    private val context: Context,
    private val list: List<IngredientResponse>,
    val onClick: (ingredient: IngredientResponse, pos: Int) -> Unit
) : RecyclerView.Adapter<AdapterProduct.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemIngredientBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(ingredient: IngredientResponse, pos: Int) {

            Glide.with(context).load(ingredient.image).into(binding.productImage)
            binding.amount.text = ingredient.amount

            itemView.setOnClickListener {
                onClick(ingredient, pos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemIngredientBinding.inflate(
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