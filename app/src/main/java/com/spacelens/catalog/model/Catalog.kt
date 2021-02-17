package com.spacelens.catalog.model

import com.google.gson.annotations.SerializedName


open class Catalog (

	@SerializedName("code") val code : Int,
	@SerializedName("message_error") val message_error : String,
	@SerializedName("products") val products : List<Product>
)