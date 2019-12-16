package com.thomasphillips3.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thomasphillips3.dogs.model.DogBreed

class ListViewModel: ViewModel() {
    val dogs = MutableLiveData<List<DogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val dog1 = DogBreed("1", "Yorkie", "20", "breedGroup", "Catching rats", "Nice", "")
        val dog2 = DogBreed("2", "Pit Bull", "10", "breedGroup", "Killin niggas", "Killaaa", "")
        val dog3 = DogBreed("3", "Labrador", "12", "breedGroup", "Companionship", "Chillin", "")

        val dogList = arrayListOf<DogBreed>(dog1, dog2, dog3)

        dogs.value = dogList
        dogsLoadError.value = false
        loading.value = false
    }
}