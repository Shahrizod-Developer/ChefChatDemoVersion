package uz.smartmuslim.chefchatdemoversion.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import uz.smartmuslim.chefchatdemoversion.data.other.Category
import java.text.FieldPosition

class ScreenSearchViewModel : ViewModel() {


    private var initValue = 1L
    val items = (1 until Category.items.size).map { longToItem(initValue++) }.toMutableList()

    fun getItemById(id: Long): String = Category.items[id.toInt()].name.toString()
    fun itemId(position: Int): Long = Category.items[position].id!!.toLong()
    val size: Int get() = items.size

    private fun longToItem(item: Long): String = Category.items[item.toInt()].name.toString()

}