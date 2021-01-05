package tech.developingdeveloper.datapersistenceretrofitexample.data.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * @author Abhishek Saxena
 * @since 06-01-2021 01:55
 */

class DogRepository(private val dogApiHelper: DogApiHelper) {

    fun getRandomDogs(number: Int = 20): Flow<DogApiResponse> = flow {
        val dogResponse = dogApiHelper.getRandomDogs(number).await()
        if (dogResponse.status == "success") {
            emit(dogResponse)
        } else {
            throw Exception (dogResponse.message.toString())
        }
    }
}