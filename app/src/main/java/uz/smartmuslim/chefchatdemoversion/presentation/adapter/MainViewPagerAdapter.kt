package uz.smartmuslim.chefchatdemoversion.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import uz.smartmuslim.chefchatdemoversion.data.ViewPagerData
import uz.smartmuslim.chefchatdemoversion.R

class MainViewPagerAdapter(private val context: Context, private val list: List<ViewPagerData>) :
    PagerAdapter() {
    @SuppressLint("InflateParams")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val sliderLayout: View = inflater.inflate(R.layout.item_viewpager, null)
        val image: ImageView = sliderLayout.findViewById(R.id.image)
        val title: TextView = sliderLayout.findViewById(R.id.title)

        list[position].image?.let { image.setImageResource(it) }
        title.text = list[position].title
        container.addView(sliderLayout)

        return sliderLayout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view === o
    }
}