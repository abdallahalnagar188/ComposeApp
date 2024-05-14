package com.example.composeapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GymViewModel() : ViewModel() {
    var state by mutableStateOf(getGyms())
    private var apiService: GymsApiService

    init {
        val retrofit: Retrofit =
            Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://console.firebase.google.com/project/cairogyms-3e3a6/database/cairogyms-3e3a6-default-rtdb/data/")
                .build()
        apiService = retrofit.create(GymsApiService::class.java)

    }

    private fun getGyms() {
        apiService.getGyms().execute().body()?.let {gymsList->
            state = gymsList
        }

    }
    fun toggleFavoriteState(gymId:Int){
        val gyms = state.toMutableList()
        val itemIndex = gyms.indexOfFirst { it.id == gymId }
        gyms[itemIndex] = gyms[itemIndex].copy(isFavorite = !gyms[itemIndex].isFavorite)
        state = gyms
    }
}