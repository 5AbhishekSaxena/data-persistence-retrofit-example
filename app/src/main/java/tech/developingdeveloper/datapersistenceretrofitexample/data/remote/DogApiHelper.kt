package tech.developingdeveloper.datapersistenceretrofitexample.data.remote


/**
 * @author Abhishek Saxena
 * @since 06-01-2021 01:52
 */

class DogApiHelper(private val dogService: DogService) {

    suspend fun getRandomDogs(number: Int) =
        dogService.getRandomDogs(number)
}