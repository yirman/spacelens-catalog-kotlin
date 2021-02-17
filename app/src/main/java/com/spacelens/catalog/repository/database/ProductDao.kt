package com.spacelens.catalog.repository.database

import com.spacelens.catalog.model.Product
import io.realm.Realm
import io.realm.RealmResults

class ProductDao : BaseDao() {

    fun insertProduct(product: Product) {
        realm.executeTransaction {
            realm.insertOrUpdate(product)
        }
    }

    fun insertProducts(products: List<Product>){
        realm.executeTransaction {
            it.insertOrUpdate(products)
        }
    }

    fun getProduct(id : Int) : Product? {
        return realm.where(Product::class.java).equalTo("productId", id).findFirst()
    }

    fun getProducts() : RealmResults<Product> {
        return realm.where(Product::class.java).findAll()
    }

}