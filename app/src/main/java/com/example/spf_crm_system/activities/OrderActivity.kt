package com.example.spf_crm_system.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spf_crm_system.R
import com.example.spf_crm_system.adapters.OrderAdapter
import com.example.spf_crm_system.adapters.ProductAdapter
import com.example.spf_crm_system.models.Product
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class OrderActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    private var dl: DrawerLayout? = null
    private var t: ActionBarDrawerToggle? = null
    private var nv: NavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val products:List<Product>
        mAuth = FirebaseAuth.getInstance();

        products= mutableListOf(
            Product(
                1,
                "на картриджи Сanon 725, 728, 737, 712; HP 278, 285",
                100,
                "Фотобарабан HP P1005"
            ),
            Product(2, "HP Q2612/FX9/FX10", 800, "Фотобарабан HP 1010"),
            Product(3, "Canon MF 3220/HP 7115", 800, "Фотобарабан HP 1200"),
            Product(4, "Q2612/FX9", 800, "Тонер MPT9, 100гр"),
            Product(5, "HP 285/278; Canon 725/728/737/712", 900, "Тонер MPT10, 80гр")
        )

        val products_list=findViewById<RecyclerView>(R.id.orders_list)
        val ordersAdapter= OrderAdapter(this, products)

        products_list.adapter=ordersAdapter
        products_list.layoutManager= LinearLayoutManager(this)


        dl = findViewById<View>(R.id.dlOrder) as DrawerLayout
        t = ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close)

        dl!!.addDrawerListener(t!!)
        t!!.syncState()

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        nv = findViewById<View>(R.id.navView2) as NavigationView
        nv!!.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            val id = item.itemId
            when (id) {
                R.id.Products -> {
                    Toast.makeText(this, "Products", Toast.LENGTH_SHORT).show()
                    val intent= Intent(this, ProductActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.MyOrders -> {
                    Toast.makeText(this, "My Orders", Toast.LENGTH_SHORT).show()
                    val intent= Intent(this, OrderActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.LogOut -> {
                    Toast.makeText(this, "Log out", Toast.LENGTH_SHORT).show()
                    val intent= Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    FirebaseAuth.getInstance().signOut();
                    true
                }
                else -> true
            }
        })
        //navigation view end no esho tam etot metod nyzhen
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (t!!.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
    }
}