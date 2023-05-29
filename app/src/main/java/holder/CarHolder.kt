package holder

import CarsData.CarsDataProvider
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.toUpperCase
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import java.util.concurrent.Executors

class CarHolder (v: View) : RecyclerView.ViewHolder(v) {
    private var view: View
    init { this.view = v }

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

        if(transmission.isNullOrBlank()){txt.text = "N/A"}
        else if(transmission == "a"){txt.text = "Automatic"}
        else if(transmission == "m"){txt.text = "Manual"}
        else {txt.text = transmission}
    }

    fun setYear(year: Int){
        val txt: TextView = view.findViewById(R.id.textCarYear)
        txt.text = year.toString()
    }

    fun setImageSrc(make: String) {
        var image: Bitmap? = null
        var imageSrc = CarsDataProvider.carsData.firstOrNull() { it.marca.toUpperCase() == make.toUpperCase()}
        val imageView: ImageView = view.findViewById(R.id.imageCarBrand)
        if (imageSrc != null) {
            val executor = Executors.newSingleThreadExecutor()
            val handler = Handler(Looper.getMainLooper())

            executor.execute {
                try {
                    val `in` = java.net.URL(imageSrc.logo).openStream()
                    image = BitmapFactory.decodeStream(`in`)
                    handler.post {
                        imageView.setImageBitmap(image)
                    }
                }
                catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}