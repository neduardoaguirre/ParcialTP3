package APIServiceBuilder

import CarsModel.Car
import CarsModel.CarsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface  CarsService {
    //@Headers("X-Api-key:NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4")
    //@GET("cars?fuel_type=electricity")
    @GET("cars?fuel_type=gas&limit=15&year=2018")
    //fun getCarsList(@Header("X-Api-key") apikey: String): Call<CarsResponse>
    //@Header("X-Api-key") apikey: String
    //@GET("pokemon?limit=100&offset=0")
    fun getCarsList(@Header("X-Api-key") apikey: String): Call<List<Car>>

}