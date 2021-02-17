@file:JvmName("RealmUtils")
package com.spacelens.catalog.utils


import io.realm.RealmObject
import io.realm.RealmResults

fun <T: RealmObject> RealmResults<T>.asLiveData() = LiveRealmResultsData(this)
fun <T: RealmObject> T.asLiveData() = LiveRealmObjectData(this)