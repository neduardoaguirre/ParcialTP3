package fragments

import CarsData.CarsDataProvider
import CarsData.CarsTypeData
import RecyclerViewAdapter.CarsMarksAdapter
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

class HomeFragment : Fragment() {

    lateinit var vista: View
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

        rec_marks.setHasFixedSize(true)
        rec_cars.setHasFixedSize(true)

        val linearLayoutManager = LinearLayoutManager(context)
        val linearLayoutManager2 =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rec_cars.layoutManager = linearLayoutManager
        rec_marks.layoutManager = linearLayoutManager2


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

        rec_cars.adapter = CarsTypesAdapter(carsTypes, vista)
        rec_marks.adapter = CarsMarksAdapter(CarsDataProvider.carsData)

        return vista;
    }

}