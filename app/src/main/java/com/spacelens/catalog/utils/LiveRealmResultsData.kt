package com.spacelens.catalog.utils

import androidx.lifecycle.LiveData
import io.realm.RealmChangeListener
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.RealmResults

class LiveRealmResultsData<T : RealmObject>(private var results: RealmResults<T>): LiveData<RealmResults<T>>() {


    private var realmChangeListener : RealmChangeListener<RealmResults<T>> = RealmChangeListener {
        value = it
    }

    override fun onActive() {
        results.addChangeListener(realmChangeListener)
    }

    override fun onInactive() {
        results.removeChangeListener(realmChangeListener)
    }
}