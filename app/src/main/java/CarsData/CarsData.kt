package CarsData

import android.graphics.drawable.Drawable
import android.net.Uri

data class CarsData(
    val marca: String,
    val cantidadModelos: String,
    val logo: String
)

data class CarsTypeData(
    val tipo: String,
    val img: Drawable? = null
)