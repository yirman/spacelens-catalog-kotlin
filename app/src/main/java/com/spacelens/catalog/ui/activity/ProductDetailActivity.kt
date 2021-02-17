package com.spacelens.catalog.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.spacelens.catalog.databinding.ActivityProductDetailBinding
import com.spacelens.catalog.viewmodel.ProductViewModel

class ProductDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PRODUCT_ID = "EXTRA_PRODUCT_ID"
    }

    private lateinit var binding : ActivityProductDetailBinding

    private lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val productId : Int = intent.extras!!.getInt(EXTRA_PRODUCT_ID)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        productViewModel.queryProduct(productId)?.observe(this, Observer {
            binding.tvProductTitle.text = it.title
            binding.tvProductDescription.text = it.description
            Glide.with(this@ProductDetailActivity)
                .load(it.attachment?.url)
                .centerInside()
                .into(binding.ivProductImage)
        })

    }
}