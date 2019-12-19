package com.thomasphillips3.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thomasphillips3.dogs.model.DogBreed

class DetailViewModel: ViewModel() {
    val dogLiveData = MutableLiveData<DogBreed>()

    fun refresh() {
        val dog = DogBreed("1", "Yorkie", "20", "breedGroup", "Catching rats", "Nice", "")
        dogLiveData.value = dog
    }

}