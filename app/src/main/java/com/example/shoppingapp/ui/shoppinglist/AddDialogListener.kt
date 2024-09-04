package com.example.shoppingapp.ui.shoppinglist

import com.example.shoppingapp.data.database.entity.ShoppingItemEntity

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItemEntity)
}