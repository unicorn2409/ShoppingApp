package com.example.shoppingapp.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppingapp.R
import com.example.shoppingapp.data.database.entity.ShoppingItemEntity

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        val etName = findViewById<TextView>(R.id.etName)
        val etAmount = findViewById<TextView>(R.id.etAmount)
        val tvAdd = findViewById<TextView>(R.id.tvAdd)
        val tvCancel = findViewById<TextView>(R.id.tvCancel)

        tvAdd?.setOnClickListener {
            val name = etName?.text.toString()
            val amount = etAmount?.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please Enter all the information", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val item = ShoppingItemEntity(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel?.setOnClickListener {
            cancel()
        }
    }
}