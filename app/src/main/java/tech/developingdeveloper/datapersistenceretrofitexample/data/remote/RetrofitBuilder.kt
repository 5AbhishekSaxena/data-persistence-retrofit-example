package tech.developingdeveloper.datapersistenceretrofitexample.data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


/**
 * @author Abhishek Saxena
 * @since 06-01-2021 01:47
 */

object RetrofitBuilder {

    private const val BASE_URL = "https://dog.ceo/api/breeds/"

    private fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val dogService: DogService = getRetrofit().create(DogService::class.java)

}