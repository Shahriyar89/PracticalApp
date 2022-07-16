package com.matrix87.room

import androidx.room.*


@Dao
interface RoomDao {
    @Query("SELECT * FROM SalesProduct")
    suspend fun getAll(): List<Product>

    @Query("SELECT * FROM SalesProduct WHERE pId IN (:id)")
    fun loadAllByIds(id: IntArray): List<Product>

    @Query("SELECT * FROM SalesProduct WHERE pTitle LIKE :title")
    fun findByName(title: String): Product

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg customer: Product)

    @Update()
    fun update(vararg customer: Product)

    @Delete
    fun delete(customer: Product)


    @Query("Delete from SalesProduct where pId =:cId")
    fun deleteById(cId: Int)
}