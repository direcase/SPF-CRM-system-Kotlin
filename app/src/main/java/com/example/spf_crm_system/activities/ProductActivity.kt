package com.example.spf_crm_system.activities

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spf_crm_system.R
import com.example.spf_crm_system.adapters.ProductAdapter
import com.example.spf_crm_system.models.Product
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.products.*


class ProductActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    private var dl: DrawerLayout? = null
    private var t: ActionBarDrawerToggle? = null
    private var nv: NavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val products:List<Product>
        mAuth = FirebaseAuth.getInstance();


        // heart button functionality
        val openDialog = Dialog(this)
        openDialog.setContentView(R.layout.products)
       val heart= openDialog.findViewById<ImageButton>(R.id.heartButton)
        var heartB:Boolean=false

       heart.setOnClickListener {
           heart.setImageResource(R.drawable.fullheart)
                Toast.makeText(this, "Item was added into orders", Toast.LENGTH_SHORT).show()

           println("Item was added into orders")

       }

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

        val products_list=findViewById<RecyclerView>(R.id.product_list)
        val productsAdapter= ProductAdapter(this, products)

        products_list.adapter=productsAdapter
        products_list.layoutManager=LinearLayoutManager(this)


        //navigation view start
        dl = findViewById<View>(R.id.dl) as DrawerLayout
        t = ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close)

        dl!!.addDrawerListener(t!!)
        t!!.syncState()

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        nv = findViewById<View>(R.id.navView) as NavigationView
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
    //vot etot
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (t!!.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
    }
}