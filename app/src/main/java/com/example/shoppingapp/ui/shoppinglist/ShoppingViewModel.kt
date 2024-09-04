package com.example.shoppingapp.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppingapp.data.database.entity.ShoppingItemEntity
import com.example.shoppingapp.data.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository): ViewModel() {

    fun insertShoppingItem(item: ShoppingItemEntity) = CoroutineScope(Dispatchers.Main).launch {
        repository.insertShoppingItem(item)
    }

    fun deleteShoppingItem(item: ShoppingItemEntity) = CoroutineScope(Dispatchers.Main).launch {
        repository.deleteShoppingItem(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}