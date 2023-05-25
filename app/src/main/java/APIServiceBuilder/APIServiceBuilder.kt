package APIServiceBuilder

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIServiceBuilder {
    private val BASE_URL = "https://api.api-ninjas.com/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): CarsService {
        return retrofit.create(CarsService::class.java)
    }
}