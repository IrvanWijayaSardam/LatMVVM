package com.aminivan.latmvvp.view

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aminivan.latmvvp.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrieveData()
    }


    fun retrieveData(){
        val intent: Intent = intent
        var status = intent.getStringExtra("status")

        Glide.with(this).load(intent.getStringExtra("image")).into(binding.ivDetail)
        binding.tvStatusDetail.text = intent.getStringExtra("status")
        binding.tvName.text = intent.getStringExtra("name")
        binding.tvPriceDetail.text = intent.getIntExtra("price",0).toString()

        Log.d(TAG, "retrieveData: ${status}")
    }

}