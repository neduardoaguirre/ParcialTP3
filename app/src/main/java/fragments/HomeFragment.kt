package fragments

import APIServiceBuilder.APIServiceBuilder
import CarsModel.Car
import CarsModel.CarTypes
import RecyclerViewAdapter.CarsAdapter
import RecyclerViewAdapter.CarsTypesAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var vista: View
    var carsTypes: MutableList<CarTypes> = ArrayList<CarTypes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vista =  inflater.inflate(R.layout.fragment_home, container, false)
        var rec_cars = vista.findViewById<RecyclerView>(R.id.rec_cars)

        rec_cars.setHasFixedSize(true)

        val linearLayoutManager = LinearLayoutManager(context)

        rec_cars.layoutManager= linearLayoutManager

        carsTypes.add(CarTypes("Deportivos", context?.let { ContextCompat.getDrawable(it, R.drawable.deportivos) }))
        carsTypes.add(CarTypes("SUV", context?.let { ContextCompat.getDrawable(it, R.drawable.suv) }))
        carsTypes.add(CarTypes("Eléctricos", context?.let { ContextCompat.getDrawable(it, R.drawable.electricos) }))

        rec_cars.adapter= CarsTypesAdapter(carsTypes)

        return vista;
    }

//    fun getCars() {
//        val service = APIServiceBuilder.create()
//
//        service.getCarsList("NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4").enqueue(object:
//            Callback<List<Car>> {
//            override fun onResponse(
//                call: Call<List<Car>>,
//                response: Response<List<Car>>
//            ) {
//                showData(response.body()!!)
//            }
//
//            override fun onFailure(call: Call<List<Car>>, t: Throwable) {
//
//            }
//        })
//    }
//
//    private fun showData(carList: List<Car>) {
//
//
//
//                findViewById<RecyclerView>(R.id.rec_cars).apply {
//                   layoutManager = LinearLayoutManager(this@HomeFragment)
//                   adapter = CarsAdapter(carList)
//               }
//
//    }




}