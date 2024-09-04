package com.example.shoppingapp.ui.shoppinglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.R
import com.example.shoppingapp.data.database.ShoppingDatabase
import com.example.shoppingapp.data.database.entity.ShoppingItemEntity
import com.example.shoppingapp.data.repository.ShoppingRepository
import com.example.shoppingapp.other.ShoppingItemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_activity_main)

        val rvShoppingItems = findViewById<RecyclerView>(R.id.rvShoppingItems)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        val db = ShoppingDatabase.getDatabase(this)
        val repository = ShoppingRepository(db)
        val viewModelFactory = ShoppingViewModelFactory(repository)

        val viewmodel = ViewModelProviders.of(this, viewModelFactory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewmodel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewmodel.getAllShoppingItems().observe(this, Observer {
            adapter.item = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(this, object : AddDialogListener {
                override fun onAddButtonClicked(item: ShoppingItemEntity) {
                    viewmodel.insertShoppingItem(item)
                }
            }).show()
        }
    }
}