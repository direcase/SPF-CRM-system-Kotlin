package com.example.spf_crm_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spf_crm_system.models.Client

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val clients:List <Client>

        val client= Client(1, "Dariya", "Bigabulova", "d@email.ru", "87478202172")

        clients= listOf(client)

        val clients_list=findViewById<RecyclerView>(R.id.clients_list)
        val clientsAdapter=ClientAdapter(this,clients)

        clients_list.adapter=clientsAdapter
        clients_list.layoutManager=LinearLayoutManager(this)
        val add=findViewById<Button>(R.id.button2) as Button
        add.setOnClickListener {
            val intent= Intent(this, ProductActivity::class.java)
            startActivity(intent)
        }
    }

}