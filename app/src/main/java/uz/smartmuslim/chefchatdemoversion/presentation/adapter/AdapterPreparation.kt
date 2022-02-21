package uz.smartmuslim.chefchatdemoversion.presentation.adapter

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.smartmuslim.chefchatdemoversion.R
import uz.smartmuslim.chefchatdemoversion.data.response.PreparationResponse
import uz.smartmuslim.chefchatdemoversion.databinding.ItemStepBinding

class AdapterPreparation(
    private val context: Context,
    private val itemCells: ArrayList<PreparationResponse>,
    private val expandedSize: ArrayList<Int>
) : RecyclerView.Adapter<AdapterPreparation.ViewHolder>() {


    class ViewHolder(binding: ItemStepBinding) : RecyclerView.ViewHolder(binding.root) {
        val step = binding.step
        val desc = binding.desc
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemStepBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.step.text = itemCells[position].step
        holder.desc.text = itemCells[position].desc

        // Set the height in answer TextView
        holder.desc.layoutParams.height = expandedSize[position]

        // Expand/Collapse the answer TextView when you tap on the question TextView
        holder.step.setOnClickListener {


            if (expandedSize[position] == 0) {
                // Calculate the height of the Answer Text
                val descTextViewHeight = itemCells[position].desc?.let { it1 ->
                    height(
                        context,
                        it1,
                        Typeface.DEFAULT,
                        16,
                        dp2px(15f, context)
                    )
                }
                if (descTextViewHeight != null) {
                    changeViewSizeWithAnimation(
                        holder.desc,
                        descTextViewHeight,
                        300L
                    )
                }
                if (descTextViewHeight != null) {
                    expandedSize[position] = descTextViewHeight
                }
            } else {
                changeViewSizeWithAnimation(holder.desc, 0, 300L)
                expandedSize[position] = 0
            }


            // Uncomment the code below if you want to expand only one at a time
//            if (lastTappedCell != null) {
//                expandedSize[lastTappedCell!!] = 0
//                notifyItemChanged(lastTappedCell!!)
//            }
//            lastTappedCell = position
        }

    }

    override fun getItemCount(): Int = itemCells.size

    private fun changeViewSizeWithAnimation(view: View, viewSize: Int, duration: Long) {
        val startViewSize = view.measuredHeight
        val endViewSize: Int =
            if (viewSize < startViewSize) (viewSize) else (view.measuredHeight + viewSize)
        val valueAnimator =
            ValueAnimator.ofInt(startViewSize, endViewSize)
        valueAnimator.duration = duration
        valueAnimator.addUpdateListener {
            val animatedValue = valueAnimator.animatedValue as Int
            val layoutParams = view.layoutParams
            layoutParams.height = animatedValue
            view.layoutParams = layoutParams
        }
        valueAnimator.start()
    }

    private fun height(
        context: Context,
        text: String,
        typeface: Typeface?,
        textSize: Int,
        padding: Int
    ): Int {
        val textView = TextView(context)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.toFloat())
        textView.setPadding(padding, padding, padding, padding)
        textView.typeface = typeface
        textView.text = text
        val mMeasureSpecWidth =
            View.MeasureSpec.makeMeasureSpec(getDeviceWidth(context), View.MeasureSpec.AT_MOST)
        val mMeasureSpecHeight = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        textView.measure(mMeasureSpecWidth, mMeasureSpecHeight)
        return textView.measuredHeight
    }

    private fun dp2px(dpValue: Float, context: Context): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    private fun getDeviceWidth(context: Context): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val displayMetrics = DisplayMetrics()
            val display: Display? = context.display
            display?.getRealMetrics(displayMetrics)
            displayMetrics.widthPixels
        } else {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val displayMetrics = DisplayMetrics()
            wm.defaultDisplay.getMetrics(displayMetrics)
            displayMetrics.widthPixels
        }
    }
}