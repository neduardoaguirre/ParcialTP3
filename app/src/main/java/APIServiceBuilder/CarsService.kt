package APIServiceBuilder

import CarsModel.Car
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface CarsService {

    @Headers("X-Api-key:NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4")
    @GET("cars?fuel_type=electricity")
    //@Header("X-Api-key") apikey: String
    //@GET("pokemon?limit=100&offset=0")
    //@Header("X-Api-key") apikey: String
     fun getElectricCarsList(): Call<List<Car>>
    @Headers("X-Api-key:NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4")
     @GET("cars?fuel_type=gas")
     fun getSportCarsList(): Call<List<Car>>
    @Headers("X-Api-key:NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4")
    @GET("cars?fuel_type=diesel")
    fun getSuvCarsList(): Call<List<Car>>
}