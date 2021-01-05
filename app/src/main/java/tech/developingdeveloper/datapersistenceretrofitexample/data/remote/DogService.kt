package tech.developingdeveloper.datapersistenceretrofitexample.data.remote

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * @author Abhishek Saxena
 * @since 06-01-2021 01:49
 */

interface DogService {

    @GET("image/random/{number}")
    fun getRandomDogs(@Path("number") number: Int): Deferred<DogApiResponse>
}