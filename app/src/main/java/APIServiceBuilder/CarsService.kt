package APIServiceBuilder

import CarsModel.Car
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface CarsService {

    @Headers("X-Api-key:NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4")
    @GET("cars?fuel_type=electricity&limit=15")
    fun getElectricCarsList(): Call<List<Car>>
    @Headers("X-Api-key:NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4")
    @GET("cars?fuel_type=gas&limit=15")
    fun getSportCarsList(): Call<List<Car>>
    @Headers("X-Api-key:NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4")
    @GET("cars?fuel_type=diesel&limit=15")
    fun getSuvCarsList(): Call<List<Car>>

    @Headers("X-Api-key:NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4")
    @GET("cars?limit=15&year=2022")
    fun getCarsList(): Call<List<Car>>

}