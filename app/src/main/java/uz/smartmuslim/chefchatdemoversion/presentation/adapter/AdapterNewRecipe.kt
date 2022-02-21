package uz.smartmuslim.chefchatdemoversion.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.smartmuslim.chefchatdemo.data.response.FoodResponse
import uz.smartmuslim.chefchatdemoversion.databinding.ItemFoodListBinding

class AdapterNewRecipe(
    private val context: Context,
    private val list: List<FoodResponse>,
    val onClick: (foodResponse: FoodResponse, pos: Int) -> Unit
) : RecyclerView.Adapter<AdapterNewRecipe.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemFoodListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(foodResponse: FoodResponse, pos: Int) {

            Glide.with(context).load(foodResponse.image).into(binding.imageFood)
            Glide.with(context).load(foodResponse.profileImage).into(binding.profileImage)
            binding.countBookmark.text = foodResponse.countBookmark.toString()
            binding.nameFood.text = foodResponse.name

            itemView.setOnClickListener {
                onClick(foodResponse, pos)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFoodListBinding.inflate(
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