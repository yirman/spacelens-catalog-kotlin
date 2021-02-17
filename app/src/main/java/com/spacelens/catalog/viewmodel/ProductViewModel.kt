package com.spacelens.catalog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.spacelens.catalog.model.Product
import com.spacelens.catalog.repository.ProductRepository
import com.spacelens.catalog.utils.LiveRealmObjectData
import com.spacelens.catalog.utils.LiveRealmResultsData
import kotlinx.coroutines.*

class ProductViewModel : ViewModel(){

    private var productRepository : ProductRepository = ProductRepository()

    fun insertProduct(product: Product){
        productRepository.insertProduct(product)
    }

    fun insertProducts(products: List<Product>){
        productRepository.insertProducts(products)
    }

    fun queryProduct(id: Int) : LiveRealmObjectData<Product>? {
        return productRepository.queryProduct(id)
    }

    fun queryAllProducts() : LiveRealmResultsData<Product> {
        return productRepository.queryAllProducts()
    }

    fun requestProductsCatalog(lat : Double, lon : Double){
        viewModelScope.launch {
            withContext(Dispatchers.Main){
                val body = productRepository.requestProductsCatalog(lat, lon).body()
                body?.products?.let { insertProducts(it) }
            }
        }
    }
}