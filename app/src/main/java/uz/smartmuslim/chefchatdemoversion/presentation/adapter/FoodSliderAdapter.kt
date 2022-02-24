package uz.smartmuslim.chefchatdemoversion.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import uz.smartmuslim.chefchatdemoversion.data.response.FoodResponse
import uz.smartmuslim.chefchatdemoversion.R


class FoodSliderAdapter(private val context: Context, private val list: List<FoodResponse>) :
    PagerAdapter() {

    @SuppressLint("InflateParams")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {


        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val sliderLayout: View = inflater.inflate(R.layout.item_food, null, false)

        val bookMark: TextView? = sliderLayout.findViewById<TextView>(R.id.countBookmark)
        bookMark?.text = list[position].countBookmark.toString()

        val comment: TextView? = sliderLayout.findViewById<TextView>(R.id.countComment)
        comment?.text = list[position].countComment.toString()

        val videoView = sliderLayout.findViewById<VideoView>(R.id.image)
        val play = sliderLayout.findViewById<ImageView>(R.id.play)

        play.setOnClickListener {

            play.visibility = View.GONE
            val mc = MediaController(context)
            mc.setAnchorView(videoView)
            mc.setMediaPlayer(videoView)
            val video =
                Uri.parse(list[position].video)
            videoView.setMediaController(mc)
            videoView.setVideoURI(video)
            videoView.start()
        }

        val gotoProfile: ImageView = sliderLayout.findViewById<ImageView>(R.id.gotoProfile)
        Glide.with(context).load(list[position].profileImage).into(gotoProfile)

        container.addView(sliderLayout)
        return sliderLayout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, o: Any): Boolean {

        return view == o
    }

}