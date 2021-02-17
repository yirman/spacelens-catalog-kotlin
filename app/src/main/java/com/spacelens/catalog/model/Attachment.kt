package com.spacelens.catalog.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class Attachment (

	@SerializedName("url") open var url : String = "",
	@SerializedName("type") open var type : String = "",
	@SerializedName("thumbnail") open var thumbnail : String = ""
): RealmObject()