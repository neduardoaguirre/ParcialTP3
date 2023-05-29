package RecyclerViewAdapter

import CarsData.CarsTypeData
import CarsModel.Car
import CarsModel.SerializableListCars
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import fragments.HomeFragment
import fragments.HomeFragmentDirections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.manager.SupportRequestManagerFragment
import kotlinx.coroutines.NonDisposableHandle.parent

class CarsTypesAdapter (private val carsTypesList: MutableList<CarsTypeData>, private val vista: View): RecyclerView.Adapter<CarsTypesAdapter.ViewHolder>(){

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
                getSportCars(holder.carsLayout, vista)
            }
            1 -> {
                holder.carsLayout.setBackgroundResource(R.drawable.radius_blue)
                getSuvCars(holder.carsLayout, vista)
            }
            2 -> {
                holder.carsLayout.setBackgroundResource(R.drawable.radius_light_blue)
                getElectricCars(holder.carsLayout, vista)
            }else ->{

            }
        }

    }

     private fun getElectricCars(card: ConstraintLayout, view:View) {
        val service = APIServiceBuilder.APIServiceBuilder.create()

        service.getElectricCarsList().enqueue(object :
            Callback<List<Car>> {
            override fun onResponse(
                call: Call<List<Car>>,
                response: Response<List<Car>>
            ) {
                showData(response.body()!!, card, view)
            }

            override fun onFailure(call: Call<List<Car>>, t: Throwable) {

            }
        })
    }

    private fun getSportCars(card: ConstraintLayout, view:View) {
        val service = APIServiceBuilder.APIServiceBuilder.create()

        service.getSportCarsList().enqueue(object :
            Callback<List<Car>> {
            override fun onResponse(
                call: Call<List<Car>>,
                response: Response<List<Car>>
            ) {
                showData(response.body()!!, card, view)
            }

            override fun onFailure(call: Call<List<Car>>, t: Throwable) {

            }
        })
    }

    private fun getSuvCars(card: ConstraintLayout, view:View) {
        val service = APIServiceBuilder.APIServiceBuilder.create()

        service.getSuvCarsList().enqueue(object :
            Callback<List<Car>> {
            override fun onResponse(
                call: Call<List<Car>>,
                response: Response<List<Car>>
            ) {
                showData(response.body()!!, card, view)
            }

            override fun onFailure(call: Call<List<Car>>, t: Throwable) {

            }
        })
    }

    private fun showData(carList: List<Car>, card: ConstraintLayout, view: View) {
        var list = SerializableListCars(carList)

        card.setOnClickListener {
            println(list)
            //val action = HomeFragmentDirections.actionHomeFragmentToPruebaFragment(list)
            val action = HomeFragmentDirections.actionHomeFragmentToAutosFragment(list)
            view.findNavController()?.navigate(action)
        }
    }
}