package uz.smartmuslim.chefchatdemoversion.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.smartmuslim.chefchatdemoversion.data.response.CommentResponse
import uz.smartmuslim.chefchatdemoversion.databinding.ItemCommentBinding


class AdapterComment(
    private val context: Context,
    private val list: List<CommentResponse>,
    val onClick: (commentResponse: CommentResponse, pos: Int) -> Unit
) : RecyclerView.Adapter<AdapterComment.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(commentResponse: CommentResponse, pos: Int) {

            Glide.with(context).load(commentResponse.image).into(binding.imageProfile)
            binding.nameUser.text = commentResponse.name
            binding.date.text = commentResponse.date
            binding.time.text = commentResponse.time
            binding.countLike.text = commentResponse.countLike.toString()
            binding.comment.text = commentResponse.comment

            itemView.setOnClickListener {
                onClick(commentResponse, pos)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCommentBinding.inflate(
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