package com.example.spf_crm_system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val clients:List <Client>

        val client=Client(1,"Dariya","Bigabulova","d@email.ru","87478202172")

        clients= listOf(client)

        val clients_list=findViewById<RecyclerView>(R.id.clients_list)
        val clientsAdapter=ClientAdapter(this,clients)
    }

}