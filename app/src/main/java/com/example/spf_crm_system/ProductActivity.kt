package com.example.spf_crm_system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spf_crm_system.models.Product

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val products:List <Product>


        products= mutableListOf(Product(1,"на картриджи Сanon 725, 728, 737, 712; HP 278, 285",100,"Фотобарабан HP P1005"),
        Product(2,"HP Q2612/FX9/FX10",800,"Фотобарабан HP 1010"),
            Product(3,"Canon MF 3220/HP 7115",800,"Фотобарабан HP 1200"),
            Product(4,"Q2612/FX9",800,"Тонер MPT9, 100гр"),
            Product(5,"HP 285/278; Canon 725/728/737/712",900,"Тонер MPT10, 80гр")
            )

        val products_list=findViewById<RecyclerView>(R.id.product_list)
        val productsAdapter=ProductAdapter(this,products)

        products_list.adapter=productsAdapter
        products_list.layoutManager=LinearLayoutManager(this)
    }
}