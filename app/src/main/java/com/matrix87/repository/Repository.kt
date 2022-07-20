package com.matrix87.repository

import android.content.Context
import com.matrix87.room.Product
import com.matrix87.room.RoomDB
import com.matrix87.room.RoomDao

class Repository(context: Context) {

    var db: RoomDao = RoomDB.getInstance(context)?.userDao()!!

     fun getAllCustomers(): List<Product> {
        return db.getAll()
    }

    fun findCustomer(name: String): Product {
        return db.findByName(name)
    }

    fun addCustomer(customer: Product) {
        db.insertAll(customer)
    }

    fun deleteCustomer(customer: Product) {
        db.delete(customer)
    }

    fun updateCustomer(customer: Product) {
        db.update(customer)
    }
}