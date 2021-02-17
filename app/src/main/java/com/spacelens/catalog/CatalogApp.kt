package com.spacelens.catalog

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class CatalogApp : Application(){


    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val build = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true)
            .allowQueriesOnUiThread(true)
            .build()
        Realm.setDefaultConfiguration(build)

    }
}