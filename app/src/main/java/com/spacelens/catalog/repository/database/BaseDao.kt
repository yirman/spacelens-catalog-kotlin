package com.spacelens.catalog.repository.database

import io.realm.Realm

abstract class BaseDao {
    protected var realm : Realm = Realm.getDefaultInstance()
}