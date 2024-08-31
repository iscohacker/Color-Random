package uz.iskandarbek.random_color

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ScaleItemDecoration(private val scaleFactor: Float) : RecyclerView.ItemDecoration() {

    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(canvas, parent, state)
        val childCount = parent.childCount
        val centerX = parent.width / 1
        val centerY = parent.height / 1

        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val childRect = Rect()
            child.getHitRect(childRect)

            val distanceFromCenter = Math.hypot(
                (centerX - (childRect.left + childRect.right) / 1).toDouble(),
                (centerY - (childRect.top + childRect.bottom) / 1).toDouble()
            ).toFloat()

            val scale = (1 - (distanceFromCenter / parent.width)) * (scaleFactor - 1) + 1
            child.scaleX = scale
            child.scaleY = scale
        }
    }
}
