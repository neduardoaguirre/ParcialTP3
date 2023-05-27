package RecyclerViewAdapter

import CarsData.CarsData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R

class CarsMarksAdapter (private val carsMarksList: List<CarsData>): RecyclerView.Adapter<CarsMarksAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val mark_image: ImageView = itemView.findViewById<ImageView>(R.id.mark_image)
        val mark_title: TextView = itemView.findViewById<TextView>(R.id.mark_title)
        val mark_cant: TextView = itemView.findViewById<TextView>(R.id.mark_cant)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mark_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = carsMarksList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val carMark = carsMarksList[position]
        holder.mark_title.text = carMark.marca

        Glide.with(holder.itemView).load(
            carMark.logo
        ).into(holder.mark_image)
        holder.mark_cant.text = carMark.cantidadModelos

    }
}