package com.example.hw3kotlin1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val listImage = arrayListOf<String>()
    private val listBackground = arrayListOf<String>()
    private val adapter by lazy {Adapter()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addImage()
        rvInit()
    }

    private fun addImage(){
        val image1 = "https://krasivosti.pro/uploads/posts/2021-07/1625891556_49-krasivosti-pro-p-kvadratnii-kot-koti-krasivo-foto-59.jpg"
        val image2 = "https://krasivosti.pro/uploads/posts/2021-07/1625891518_11-krasivosti-pro-p-kvadratnii-kot-koti-krasivo-foto-12.jpg"
        val image3 = "https://krasivosti.pro/uploads/posts/2021-07/1625891482_1-krasivosti-pro-p-kvadratnii-kot-koti-krasivo-foto-1.jpg"
        val imageBack = "https://pbs.twimg.com/media/FNKiNYvXEAAN0Lh?format=png&name=900x900"
        listImage.add(image1)
        listImage.add(image2)
        listImage.add(image3)
        listImage.add(image1)
        listImage.add(image2)
        listImage.add(image3)
        listImage.add(image1)
        listImage.add(image2)
        listImage.add(image3)
        listImage.add(image2)
        listImage.add(image3)
        listImage.add(image1)
        listImage.add(image2)
        listImage.add(image3)
        listImage.add(image3)
        listBackground.add(imageBack)
        listBackground.add(imageBack)
        listBackground.add(imageBack)
    }

    fun rvInit(){
        adapter.update(listImage, listBackground)
        val rv = findViewById<RecyclerView>(R.id.rv_image)
        rv.adapter = adapter
    }
}
