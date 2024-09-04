package com.example.shoppingapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//purpose - To hold Data

@Entity(tableName = "shopping_items")
data class ShoppingItemEntity(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}