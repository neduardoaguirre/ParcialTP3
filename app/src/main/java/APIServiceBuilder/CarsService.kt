package APIServiceBuilder

import CarsModel.Car
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface CarsService {

    @Headers("X-Api-key:NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4")
    @GET("cars?fuel_type=electricity")
    fun getElectricCarsList(): Call<List<Car>>
    @Headers("X-Api-key:NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4")
    @GET("cars?fuel_type=gas")
    fun getSportCarsList(): Call<List<Car>>
    @Headers("X-Api-key:NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4")
    @GET("cars?fuel_type=diesel")
    fun getSuvCarsList(): Call<List<Car>>

    @Headers("X-Api-key:NytbaVuK48jcFV44ssUHjRVUPLxQ8GDl8osK6xe4")
    @GET("cars?limit=15&year=2022")
    fun getCarsList(): Call<List<Car>>

}