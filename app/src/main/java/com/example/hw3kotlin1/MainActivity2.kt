package com.example.hw3kotlin1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.hw3kotlin1.databinding.ActivityMain2Binding
import com.example.hw3kotlin1.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var adapter: SecondAdapter
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private var list = arrayListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        registerForActivity()
        createList()
        initRecycler()
    }

    private fun initRecycler() {

        adapter = SecondAdapter()
        adapter.setImage(list)
        binding.rvImage.adapter = adapter

    }

    private fun createList() {

        intent.getIntegerArrayListExtra("image")?.let {
            list.addAll(it)
        }

    }

    private fun registerForActivity() {

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if (result.resultCode == Activity.RESULT_OK){
                result.data?.getIntegerArrayListExtra("image")?.let {
                    list.addAll(it)
                }
            }
        }

    }
}