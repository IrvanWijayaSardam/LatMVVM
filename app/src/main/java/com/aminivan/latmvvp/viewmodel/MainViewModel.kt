package com.aminivan.latmvvp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aminivan.latmvvp.model.getAllCarItem
import com.aminivan.latmvvp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    lateinit var liveDataList : MutableLiveData<List<getAllCarItem>>

    init{
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<getAllCarItem>>{
        return liveDataList
    }

    fun getCar(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<getAllCarItem>> {
                override fun onResponse(
                    call: Call<List<getAllCarItem>>,
                    response: Response<List<getAllCarItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataList.postValue(response.body())
                    }else{
                        liveDataList.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<getAllCarItem>>, t: Throwable) {
                    liveDataList.postValue(null)
                }

            })
    }

}