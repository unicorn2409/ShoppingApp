package com.example.shoppingapp.data.repository

import com.example.shoppingapp.data.database.ShoppingDatabase
import com.example.shoppingapp.data.database.entity.ShoppingItemEntity

class ShoppingRepository(private val db: ShoppingDatabase) {

    suspend fun insertShoppingItem(item: ShoppingItemEntity) = db.getShoppingDao().insertShoppingItem(item)

    suspend fun deleteShoppingItem(item: ShoppingItemEntity) = db.getShoppingDao().deleteShoppingItem(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItem()
}