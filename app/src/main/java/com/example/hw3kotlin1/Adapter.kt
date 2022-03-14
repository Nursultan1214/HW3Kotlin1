package com.example.hw3kotlin1

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3kotlin1.databinding.ItemBinding

class Adapter(private var onClick: OnItemClick): RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var image = arrayListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     holder.bind(image[position])
    }

    override fun getItemCount(): Int {
        return image.size
    }

    fun setImage(image: ArrayList<Int>){
        this.image.addAll(image)
        notifyDataSetChanged()
    }

   inner class ViewHolder (private val binding: ItemBinding):  RecyclerView.ViewHolder(binding.root){
        fun bind(image: Int){
            binding.ivPhoto.setImageResource(image)
            binding.ivPhoto.setOnClickListener {
                binding.ivBackground.visibility = View.VISIBLE
                onClick.onClick(image)
            }
            binding.ivBackground.setOnClickListener {
                binding.ivBackground.visibility = View.GONE
                onClick.deleteClick(image)
            }
        }

    }

    interface OnItemClick {
        fun onClick(image: Int)
        fun deleteClick(image: Int)
    }

}
