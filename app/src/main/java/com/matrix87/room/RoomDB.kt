package com.matrix87.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Product::class], version = 2)
abstract class RoomDB : RoomDatabase() {

    abstract fun userDao(): RoomDao

    companion object {
        private var INSTANCE: RoomDB? = null
        val migration1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("Drop  table  SalesProduct ")
            }
        }

        fun getInstance(context: Context): RoomDB? {
            if (INSTANCE == null) {
                synchronized(RoomDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        RoomDB::class.java, "myCustomer.db"
                    ).allowMainThreadQueries()
                        .addMigrations(migration1_2)
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}