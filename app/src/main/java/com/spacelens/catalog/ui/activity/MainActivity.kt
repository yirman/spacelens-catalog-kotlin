package com.spacelens.catalog.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.spacelens.catalog.databinding.ActivityMainBinding
import com.spacelens.catalog.ui.adapter.ProductAdapter
import com.spacelens.catalog.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rvProducts.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        productViewModel.queryAllProducts().observe(this, {

            binding.rvProducts.adapter = ProductAdapter(context = this@MainActivity, products = it)

            for(product in it){
                Log.d("Main", product.title)
            }
        })
        productViewModel.requestProductsCatalog(1.0, 1.0)
    }
}