package com.aminivan.latmvvpnetwork

import com.aminivan.latmvvp.model.getAllCarItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("admin/car")
    fun getAllCar() : Call<List<getAllCarItem>>

}