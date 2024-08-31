package uz.iskandarbek.random_color

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

class ScaleItemAnimator : DefaultItemAnimator() {

    override fun animateAdd(holder: RecyclerView.ViewHolder): Boolean {
        val view = holder.itemView
        view.scaleX = 0.5f
        view.scaleY = 0.5f
        return super.animateAdd(holder).apply {
            val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 2f)
            val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 2f)
            scaleX.duration = 400
            scaleY.duration = 400
            scaleX.start()
            scaleY.start()
        }
    }

    override fun animateRemove(holder: RecyclerView.ViewHolder): Boolean {
        val view = holder.itemView
        return super.animateRemove(holder).apply {
            val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 2f, 1f)
            val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 2f, 1f)
            scaleX.duration = 400
            scaleY.duration = 400
            scaleX.start()
            scaleY.start()
        }
    }
}
