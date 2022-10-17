package com.aminivan.latmvvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aminivan.latmvvp.databinding.ActivityMainBinding
import com.aminivan.latmvvp.view.CarAdapter
import com.aminivan.latmvvp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showdatacar()
    }

    fun showdatacar(){
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, {
            if(it != null) {
                binding.rvCar.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                binding.rvCar.adapter = CarAdapter(it)
                val adapter = CarAdapter(it)
                adapter.notifyDataSetChanged()
            }
        })
        viewModel.getCar()
    }

}