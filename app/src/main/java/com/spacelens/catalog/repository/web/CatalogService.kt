package com.spacelens.catalog.repository.web

import com.spacelens.catalog.model.Catalog
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatalogService {

    @GET("test/products_list.php")
    suspend fun requestCatalog(@Query("latitude") latitude : Double, @Query("longitude") longitude : Double) : Response<Catalog>

}