package com.imnstudios.offlinecaching.features.restaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.imnstudios.offlinecaching.R
import com.imnstudios.offlinecaching.databinding.ActivityRestaurantBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {

    private val viewModel: RestaurantViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantAdapter = RestaurantAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@RestaurantActivity)
            }

            viewModel.restaurants.observe(this@RestaurantActivity) { restaurants ->
                restaurantAdapter.submitList(restaurants)
            }
        }
    }
}