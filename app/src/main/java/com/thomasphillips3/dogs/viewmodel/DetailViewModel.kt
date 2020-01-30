package com.thomasphillips3.dogs.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.thomasphillips3.dogs.model.DogBreed
import com.thomasphillips3.dogs.model.DogDatabase
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : BaseViewModel(application) {
    val dogLiveData = MutableLiveData<DogBreed>()

    fun refresh(uuid: Int) {
        launch {
            val dog = DogDatabase(getApplication()).dogDao().getDog(uuid)
            dogLiveData.value = dog
        }
    }
}