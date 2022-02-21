package uz.smartmuslim.chefchatdemoversion.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import uz.smartmuslim.chefchatdemo.data.response.FoodResponse
import uz.smartmuslim.chefchatdemoversion.R
import uz.smartmuslim.chefchatdemoversion.presentation.ui.viewmodel.ScreenSearchViewModel


class AdapterTab(
    private val context: Context,
    private val viewModel: ScreenSearchViewModel,
    private val list: List<FoodResponse>
) : RecyclerView.Adapter<AdapterTab.TabViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): TabViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.item_mutable,
            parent, false
        )
        return TabViewHolder(v)
    }

    override fun getItemCount(): Int = if (viewModel.items.size > 0) viewModel.items.size else 0

    override fun getItemId(position: Int): Long = viewModel.itemId(position)

    override fun onBindViewHolder(holder: TabViewHolder, position: Int) {
        val itemId = holder.itemId

        holder.bind(viewModel.getItemById(itemId), list)
    }

    inner class TabViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = view.findViewById(R.id.title)
        private val rv: RecyclerView = view.findViewById(R.id.rv)

        fun bind(item: String, list: List<FoodResponse>) {

            title.text = item
            rv.adapter = AdapterNewRecipe(context, list) { it, pos ->
                Toast.makeText(context, "Salom", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

