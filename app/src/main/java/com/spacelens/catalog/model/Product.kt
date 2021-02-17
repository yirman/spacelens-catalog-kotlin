package com.spacelens.catalog.model

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Product (

	@PrimaryKey
	@SerializedName("product_id") open var productId : Int? = 0,
	@SerializedName("lat") open var lat : Double? = 0.0,
	@SerializedName("lon") open var lon : Double? = 0.0,
	@SerializedName("owner") open var owner : String? = "",
	@SerializedName("created") open var created : String? = "",
	@SerializedName("likes") open var likes : Int? = 0,
	@SerializedName("address") open var address : String? = "",
	@SerializedName("createdTime") open var createdTime : String? = "",
	@SerializedName("is_private") open var isPrivate : Int? = 0,
	@SerializedName("price") open var price : Int? = 0,
	@SerializedName("p_condition") open var pCondition : String? = "",
	@SerializedName("category") open var category : String? = "",
	@SerializedName("payment_method") open var payment_method : String? = "",
	@SerializedName("title") open var title : String? = "",
	@SerializedName("description") open var description : String? = "",
	@SerializedName("currency") open var currency : String? = "",
	@SerializedName("offer") open var offer : Boolean? = false,
	@SerializedName("rating_product") open var ratingProduct : Int? = 0,
	@SerializedName("rating_amount") open var ratingAmount : Int? = 0,
	@SerializedName("distance") open var distance : Int? = 0,
	@SerializedName("like_user") open var like_user : Boolean? = false,
	@SerializedName("location") open var location : Location? = null,
	@SerializedName("attachment") open var attachment : Attachment? = null
): RealmObject()