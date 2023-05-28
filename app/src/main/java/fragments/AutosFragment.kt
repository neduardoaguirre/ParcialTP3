package fragments

import APIServiceBuilder.APIServiceBuilder
import CarsModel.Car
import CarsModel.CarModel
import CarsModel.CarsResponse
import RecyclerViewAdapter.CarsAdapter
import RecyclerViewAdapter.CarsListAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.HomeActivity


class AutosFragment : Fragment() {

    lateinit var vista: View
    var carList: MutableList<CarModel> = ArrayList<CarModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_autos, container, false)



        /*
        //Carga de lista fija
        for(i in 1 .. 10){
            carList.add(CarModel("Model $i", 1,"Type $i", "Tramsission $i", "Cylinder $i", "Brand $i"))
        }
        val rec_autos = vista.findViewById<RecyclerView>(R.id.rec_autos)
        rec_autos.setHasFixedSize(true)
        var linearLayoutManager = LinearLayoutManager(context)
        rec_autos.layoutManager = linearLayoutManager
        rec_autos.adapter = CarsListAdapter(carList)
        */


        getCarList()

        return vista
    }


    fun getCarList(){
        val service = APIServiceBuilder.create()

        service.getCarsList("NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4").enqueue(object: Callback<List<Car>>{

            override fun onResponse(call: Call<List<Car>>, response: Response<List<Car>>) {
                showData(response.body()!!)
                Log.e("Response", response.body()!!.toString())
            }

            override fun onFailure(call: Call<List<Car>>, t: Throwable) {
                TODO("Not yet implemented")
                Log.e("Error throw", t.stackTraceToString())
            }

        })

    }



    private fun showData(carList: List<Car>){

            val rec_autos = vista.findViewById<RecyclerView>(R.id.rec_autos)
            rec_autos.setHasFixedSize(true)
            var linearLayoutManager = LinearLayoutManager(context)
            rec_autos.layoutManager = linearLayoutManager
            rec_autos.adapter = CarsListAdapter(carList)

        }

}




