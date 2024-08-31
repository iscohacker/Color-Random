package uz.iskandarbek.random_color.adapters

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import uz.iskandarbek.random_color.R

class ColorAdapter(private val colors: List<Int>) : RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val colorView: View = itemView.findViewById(R.id.colorView)
        val colorCodeText: TextView = itemView.findViewById(R.id.colorCodeText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ColorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val color = colors[position]
        holder.colorView.setBackgroundColor(color)
        val colorCode = String.format("#%06X", 0xFFFFFF and color)
        holder.colorCodeText.text = colorCode

        holder.colorView.setOnClickListener {
            val clipboard = holder.itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Color Code", colorCode)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(holder.itemView.context, "Rang kodi nusxalandi!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return colors.size
    }
}
