package com.imnstudios.offlinecaching.features.restaurants

import androidx.lifecycle.*
import com.imnstudios.offlinecaching.api.RestaurantApi
import com.imnstudios.offlinecaching.data.Restaurant
import com.imnstudios.offlinecaching.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class RestaurantViewModel @Inject constructor(
//    api: RestaurantApi
//) : ViewModel() {
//    private val restaurantsLiveData = MutableLiveData<List<Restaurant>>()
//    val restaurants: LiveData<List<Restaurant>> = restaurantsLiveData
//
//    init {
//        viewModelScope.launch {
//            val restaurants = api.getRestaurants()
//            delay(2000)
//            restaurantsLiveData.value = restaurants
//        }
//    }
//}

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()
}