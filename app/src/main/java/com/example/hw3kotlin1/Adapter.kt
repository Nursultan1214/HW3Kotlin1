package com.example.hw3kotlin1

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw3kotlin1.databinding.ItemBinding
import com.squareup.picasso.Picasso

class Adapter(): RecyclerView.Adapter<ViewHolder>() {
    private var image = mutableListOf<String>()
    private var back = mutableListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bind = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     holder.bind(image[position])
    }

    override fun getItemCount(): Int {
        return image.size
    }

    fun update (image: List<String>, back: List<String>){
        this.image.addAll(image)
        this.back.addAll(back)
    }

}

class ViewHolder (private val binding: ItemBinding):  RecyclerView.ViewHolder(binding.root){
      @SuppressLint("ResourceAsColor")
      fun bind(image: String){
          Picasso.get()
              .load(image)
              .into(binding.ivPhoto)
          binding.ivPhoto.setBackgroundColor(R.color.black)


      }

}