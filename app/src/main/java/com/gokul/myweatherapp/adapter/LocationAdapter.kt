package com.gokul.myweatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gokul.myweatherapp.activity.CellClickListener
import com.gokul.myweatherapp.databinding.ItemLocationBinding
import com.gokul.myweatherapp.model.WeatherLocation

class LocationAdapter(private val data: List<WeatherLocation>, private val cellClickListener: CellClickListener) : RecyclerView.Adapter<LocationAdapter.MyViewHolder>()  {

    class MyViewHolder(val binding: ItemLocationBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.textName.text = data.get(position).title
        holder.binding.textType.text = data.get(position).location_type
        holder.itemView.setOnClickListener {
            cellClickListener.locationOnClick(position, data.get(position).woeid)
        }
    }

    override fun getItemCount(): Int = data.size
}