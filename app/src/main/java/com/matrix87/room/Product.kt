package com.matrix87.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SalesProduct")
data class Product(
    @PrimaryKey @ColumnInfo(name = "pId") val id: Int,
    @ColumnInfo(name = "url") val image: String,
    @ColumnInfo(name = "pTitle") val title: String,
    @ColumnInfo(name = "pSubtitle") val subtitle: String,
    @ColumnInfo(name = "detail") val detail: String?=null

)