package tech.developingdeveloper.datapersistenceretrofitexample.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import tech.developingdeveloper.datapersistenceretrofitexample.data.model.Dog
import tech.developingdeveloper.datapersistenceretrofitexample.data.remote.DogApiHelper
import tech.developingdeveloper.datapersistenceretrofitexample.data.remote.DogRepository
import tech.developingdeveloper.datapersistenceretrofitexample.data.remote.RetrofitBuilder
import tech.developingdeveloper.datapersistenceretrofitexample.util.Status


/**
 * @author Abhishek Saxena
 * @since 06-01-2021 02:05
 */

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val dogApiHelper = DogApiHelper(RetrofitBuilder.dogService)
    private val dogRepository = DogRepository(dogApiHelper)

    val dogs: LiveData<List<Dog>> = dogRepository.getRandomDogs()
        .onStart {
            // loading
            _status.postValue(Status.LOADING)
        }
        .map {
            val dogs = it.convertToDogs()
            dogs
        }
        .catch {
            // handle exceptions
            _status.postValue(Status.ERROR)

        }
        .flowOn(Dispatchers.IO)
        .onCompletion {
            // completed
            _status.postValue(Status.DONE)

        }
        .asLiveData(Dispatchers.IO)

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status


}