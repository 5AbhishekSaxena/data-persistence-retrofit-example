package tech.developingdeveloper.datapersistenceretrofitexample.data.remote

import tech.developingdeveloper.datapersistenceretrofitexample.data.model.Dog

data class DogApiResponse(
    val message: List<String>,
    val status: String,
    val code: Int? = null
) {
    fun convertToDogs(): List<Dog> {
        return if (status == "success") {
            message.map {
                Dog(it)
            }
        } else {
            listOf()
        }
    }
}