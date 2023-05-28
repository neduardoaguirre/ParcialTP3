package RecyclerViewAdapter

import CarsModel.Car
import CarsModel.CarModel
import CarsModel.CarsResponse
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import holder.CarHolder


class CarsListAdapter(
    private val carList: List<Car>
    //Aca se cambia por List<Car> utilizado para la response del servicio
) : RecyclerView.Adapter<CarHolder>(){

    override fun getItemCount(): Int{
        return carList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_auto, parent, false)
        return CarHolder(view)
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        var car = carList[position]
        holder.setModel(car.model)
        holder.setFuelType(car.fuel_type)
        holder.setTransmission(car.transmission)
        holder.setYear(car.year)
    }



}