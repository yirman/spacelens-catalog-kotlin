package com.spacelens.catalog.repository


import com.google.gson.GsonBuilder
import com.spacelens.catalog.model.Catalog
import com.spacelens.catalog.model.Product
import com.spacelens.catalog.repository.database.ProductDao
import com.spacelens.catalog.repository.web.BasicAuthInterceptor
import com.spacelens.catalog.repository.web.CatalogService
import com.spacelens.catalog.utils.LiveRealmObjectData
import com.spacelens.catalog.utils.LiveRealmResultsData
import com.spacelens.catalog.utils.asLiveData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ProductRepository {


    private var productDao : ProductDao = ProductDao()
    private lateinit var catalogService : CatalogService

    fun insertProduct(product: Product){
        productDao.insertProduct(product)
    }

    fun insertProducts(products: List<Product>){
        productDao.insertProducts(products)
    }

    fun queryProduct(id: Int) : LiveRealmObjectData<Product>? {
        return productDao.getProduct(id)?.asLiveData()
    }

    fun queryAllProducts() : LiveRealmResultsData<Product>{
        return productDao.getProducts().asLiveData()
    }

    suspend fun requestProductsCatalog(lat : Double, lon : Double) : Response<Catalog> {
        return getRetrofit().create(CatalogService::class.java).requestCatalog(lat, lon)
    }

    companion object{

        private const val BASE_URL = "https://devapis.spacelens.com/"
        private const val USER = "test"
        private const val PASSWORD = "Fcb7mPap"


        private fun getRetrofit() : Retrofit {

            val okHttpBuilder : OkHttpClient.Builder = OkHttpClient.Builder()
            val logginInterceptor = HttpLoggingInterceptor()
            logginInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpBuilder.addNetworkInterceptor(logginInterceptor)
            okHttpBuilder.addNetworkInterceptor(BasicAuthInterceptor(USER, PASSWORD))

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client(okHttpBuilder.build())
                .build()
        }
    }


}