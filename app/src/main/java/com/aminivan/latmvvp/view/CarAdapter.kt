package com.aminivan.latmvvp.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aminivan.latmvvp.databinding.ItemCarBinding
import com.aminivan.latmvvp.model.getAllCarItem
import com.bumptech.glide.Glide

class CarAdapter(private var carData : List<getAllCarItem>): RecyclerView.Adapter<CarAdapter.ViewHolder>() {
    private lateinit var context : Context

    class ViewHolder(val binding : ItemCarBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(carData[position].image).into(holder.binding.imgCar)
        holder.binding.tvName.text = carData[position].name
        holder.binding.tvStatus.text = carData[position].status.toString()
        holder.binding.tvPrice.text = carData[position].price.toString()
        holder.binding.rlCards.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("status", carData[position].status.toString())
            bundle.putString("name",carData[position].name)
            bundle.putString("image",carData[position].image)
            bundle.putInt("price",carData[position].price)

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)

        }
    }
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun getItemCount(): Int {
        return carData.size
    }
}