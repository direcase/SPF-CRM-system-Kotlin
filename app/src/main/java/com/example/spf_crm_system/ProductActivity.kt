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


        products= listOf(Product(1,"на картриджи Сanon 725, 728, 737, 712; HP 278, 285",100,"Фотобарабан HP P1005"))

        val products_list=findViewById<RecyclerView>(R.id.product_list)
        val productsAdapter=ProductAdapter(this,products)

        products_list.adapter=productsAdapter
        products_list.layoutManager=LinearLayoutManager(this)
    }
}