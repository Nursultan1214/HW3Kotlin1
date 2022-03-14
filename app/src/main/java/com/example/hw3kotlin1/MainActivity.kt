package com.example.hw3kotlin1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.hw3kotlin1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val list = arrayListOf<Int>()
    private val listImage = arrayListOf<Int>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : Adapter
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addImage()
        rvInit()
        registerForActivity()
        fabClick()

    }

    private fun registerForActivity() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if (result.resultCode == Activity.RESULT_OK){
                Log.e("TAG", "registerForActivity: $result" )
            }
        }
    }

    private fun  fabClick() {
        binding.fab.setOnClickListener{
            openActivityResult()
        }
    }

    private fun openActivityResult() {
       Intent(this, MainActivity2::class.java).apply {
           putExtra("image", listImage)
           resultLauncher.launch(this)
       }
    }

    private fun addImage(){
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)
           list.add(R.drawable.googleisjdf)

    }

    fun rvInit(){
       adapter = Adapter(object: Adapter.OnItemClick{
           override fun onClick(image: Int) {
               listImage.add(image)
           }

           override fun deleteClick(image: Int) {
           }

       })
        adapter.setImage(list)
        binding.rvImage.adapter = adapter
    }
}
