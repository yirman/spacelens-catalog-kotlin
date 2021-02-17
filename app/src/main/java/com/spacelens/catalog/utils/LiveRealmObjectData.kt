package com.spacelens.catalog.utils

import androidx.lifecycle.LiveData
import io.realm.RealmChangeListener
import io.realm.RealmModel
import io.realm.RealmObject

class LiveRealmObjectData<T : RealmObject> (private var realmModel : T) : LiveData<T>() {

    init {
        value = realmModel
    }

    private var realmChangeListener : RealmChangeListener<T> = RealmChangeListener {
        value = it
    }

    override fun onActive() {
        realmModel.addChangeListener(realmChangeListener)
    }

    override fun onInactive() {
        realmModel.removeChangeListener(realmChangeListener)
    }

}