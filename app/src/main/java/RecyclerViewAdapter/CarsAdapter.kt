package RecyclerViewAdapter

import CarsModel.Car
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class CarsAdapter (private val carsList: List<Car>): RecyclerView.Adapter<CarsAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById<TextView>(R.id.carTypeTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_type_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = carsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = carsList[position]
        holder.name.text = car.make
    }
}