package fragments

import CarsData.CarsDataProvider
import CarsData.CarsTypeData
import CarsModel.Car
import CarsModel.SerializableListCars
import RecyclerViewAdapter.CarsAdapter
import RecyclerViewAdapter.CarsMarksAdapter
import RecyclerViewAdapter.CarsTypesAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.HomeActivity
import com.example.myapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var vista: View
    lateinit var boton: Button
    var carsTypes: MutableList<CarsTypeData> = ArrayList<CarsTypeData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vista = inflater.inflate(R.layout.fragment_home, container, false)
        var rec_cars = vista.findViewById<RecyclerView>(R.id.rec_cars)
        var rec_marks = vista.findViewById<RecyclerView>(R.id.rec_marks)
        var card = vista.findViewById<ConstraintLayout>(R.id.carsTypesLayout)

        rec_marks.setHasFixedSize(true)
        rec_cars.setHasFixedSize(true)

        val linearLayoutManager = LinearLayoutManager(context)
        val linearLayoutManager2 =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        rec_cars.layoutManager = linearLayoutManager
        rec_marks.layoutManager = linearLayoutManager2

        boton = vista.findViewById<Button>(R.id.button)

        getCars(boton, vista)

        carsTypes.add(
            CarsTypeData(
                "Deportivos",
                context?.let { ContextCompat.getDrawable(it, R.drawable.deportivos) })
        )
        carsTypes.add(
            CarsTypeData(
                "SUV",
                context?.let { ContextCompat.getDrawable(it, R.drawable.suv) })
        )
        carsTypes.add(
            CarsTypeData(
                "Eléctricos",
                context?.let { ContextCompat.getDrawable(it, R.drawable.electricos) })
        )

        rec_cars.adapter = CarsTypesAdapter(carsTypes, childFragmentManager)
        rec_marks.adapter = CarsMarksAdapter(CarsDataProvider.carsData)

        return vista;
    }

    private fun getCars(boton: Button, view: View) {
        val service = APIServiceBuilder.APIServiceBuilder.create()

        service.getCarsList("NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4").enqueue(object :
            Callback<List<Car>> {
            override fun onResponse(
                call: Call<List<Car>>,
                response: Response<List<Car>>
            ) {
                showData(response.body()!!, boton, view)
            }

            override fun onFailure(call: Call<List<Car>>, t: Throwable) {

            }
        })
    }
    private fun showData(carList: List<Car>, boton: Button, view: View) {
        var list = SerializableListCars(carList)

        boton.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToPruebaFragment3(list)
            val actividad = requireActivity()

            actividad.findViewById<View>(R.id.activity).findNavController()?.navigate(action)
        }
    }

}