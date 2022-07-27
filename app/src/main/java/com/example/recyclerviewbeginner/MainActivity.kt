package com.example.recyclerviewbeginner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewbeginner.adapter.FoodItemAdapter
import com.example.recyclerviewbeginner.databinding.ActivityMainBinding
import com.example.recyclerviewbeginner.model.FoodItem

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: FoodItemAdapter
    private lateinit var binding: ActivityMainBinding
    private val foodItemsList: MutableList<FoodItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateList()

        setUpAdapter()
    }

    private fun setUpAdapter() {

        adapter = FoodItemAdapter(this,foodItemsList)

        binding.foodItemsRV.adapter = adapter
        binding.foodItemsRV.layoutManager = LinearLayoutManager(this)
    }

    private fun populateList() {
        for (i in 1..15){
            val name = "Food Item $i"
            val price = (100 * i).toFloat()

            val foodItem = FoodItem(name = name, price = price)

            foodItemsList.add(foodItem)
        }
    }
}