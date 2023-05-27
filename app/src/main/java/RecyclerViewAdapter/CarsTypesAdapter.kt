package RecyclerViewAdapter

import CarsModel.CarTypes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class CarsTypesAdapter (private val carsTypesList: MutableList<CarTypes>): RecyclerView.Adapter<CarsTypesAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val carsLayout: ConstraintLayout = itemView.findViewById<ConstraintLayout>(R.id.carsTypesLayout)
        val carTypeTitle: TextView = itemView.findViewById<TextView>(R.id.carTypeTitle)
        val carTypeImage: ImageView? = itemView.findViewById<ImageView>(R.id.carTypeImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_type_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = carsTypesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val carType = carsTypesList[position]
        holder.carTypeTitle.text = carType.tipo
        holder.carTypeImage?.setImageDrawable(carType.img)
        when(position){
            0 -> {
                holder.carsLayout.setBackgroundResource(R.drawable.radius_yellow)
            }
            1 -> {
                holder.carsLayout.setBackgroundResource(R.drawable.radius_blue)
            }
            else -> {
                holder.carsLayout.setBackgroundResource(R.drawable.radius_light_blue)
            }
        }

    }
}