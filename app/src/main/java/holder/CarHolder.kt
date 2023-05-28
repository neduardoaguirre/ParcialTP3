package holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.compose.ui.text.capitalize
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class CarHolder (v: View) : RecyclerView.ViewHolder(v) {

    private var view: View

    init {
        this.view = v
    }

    fun setModel(model: String) {
        val txt: TextView = view.findViewById(R.id.textCarModel)
        txt.text = model
    }

    fun setFuelType(fuel_type: String){
        val txt: TextView = view.findViewById(R.id.textCarFuelType)
        txt.text = fuel_type
    }

    fun setTransmission(transmission: String?){
        val txt: TextView = view.findViewById(R.id.textCarTransmition)
        if(transmission.isNullOrBlank()){
            txt.text = "N/A"
        }
        else if(transmission == "a"){
            txt.text = "Automatic"
        }else if(transmission == "m"){
            txt.text = "Manual"
        }else {
            txt.text = transmission
        }

    }

    //fun getCardLayout (): CardView {
    //    return view.findViewById(R.id.card_package_item)
    //}

    fun setYear(year: Int){
        val txt: TextView = view.findViewById(R.id.textCarYear)
        txt.text = year.toString()
    }


    //fun setBrand(brand: String){
    //    val src: ImageView = view.findViewById(R.id.imageCarBrand)
    //    src.srcCompat = brand
    //}


//        fun getImageView () : ImageView {
//            return view.findViewById(R.id.img_item)
//        }
}