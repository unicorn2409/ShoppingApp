package com.example.shoppingapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppingapp.data.database.entity.ShoppingItemEntity


@Database(entities = [ShoppingItemEntity::class], version = 1, exportSchema = false)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null

        fun getDatabase(context: Context): ShoppingDatabase {
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ShoppingDatabase::class.java,
                        "shopping_database"
                    ).build()
                }
            }
            return instance!!
        }
    }
}