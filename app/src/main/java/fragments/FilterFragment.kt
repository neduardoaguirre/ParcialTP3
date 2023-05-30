package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgument
import com.example.myapplication.R


class FilterFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_filter, container, false)

        var carList = FilterFragmentArgs.fromBundle(requireArguments()).carList
        vista.findViewById<TextView>(R.id.carFilter).text = carList.listCars[2].make
        return vista
    }

}