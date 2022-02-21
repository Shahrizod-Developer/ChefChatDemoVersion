package uz.smartmuslim.chefchatdemoversion.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.smartmuslim.chefchatdemoversion.data.other.Photo
import uz.smartmuslim.chefchatdemoversion.databinding.ItemArticleBinding
import uz.smartmuslim.chefchatdemoversion.databinding.ItemPhotosBinding

class AdapterPhotos(
    private val context: Context,
    private val list: List<Photo>,
    val onClick: (photo: Photo, pos: Int) -> Unit
) : RecyclerView.Adapter<AdapterPhotos.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemPhotosBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(photo: Photo, pos: Int) {

            Glide.with(context).load(photo.image).into(binding.image)

            itemView.setOnClickListener {
                onClick(photo, pos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPhotosBinding.inflate(
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