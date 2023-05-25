package APIServiceBuilder

import CarsModel.CarsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface CarsService {
    @GET("cars?fuel_type=electricity")
    @Headers("X-Api-Key:UtQ+BHO7UZ3hIoWP6x6u0Q==VwfRIAhi2t0ZIXPw")

    fun getCarsList(): Call<CarsResponse>
}