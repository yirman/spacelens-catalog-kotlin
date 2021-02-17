package com.spacelens.catalog.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class Location (
	@SerializedName("latitude") open var latitude : Double = 0.0,
	@SerializedName("longitude") open var longitude : Double = 0.0
): RealmObject()