package com.example.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var  rvpersona:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        rvpersona= findViewById(R.id.rvPersona)
    }

    override fun onResume() {
        super.onResume()
        val adaptador= Adaptador(this)
        rvpersona.adapter= adaptador
        rvpersona.layoutManager=LinearLayoutManager(this)

    }
    fun onClickPersona(persona: Persona){
        val intent =Intent(this,Editar::class.java)
        intent.putExtra("nombre",persona.nombre)
        intent.putExtra("apellido",persona.apellido)
        intent.putExtra("edad",persona.edad)
        intent.putExtra("id",persona.id)
        startActivity(intent)
    }
    fun mandaragregar(v:View){
        val intent = Intent(this,AgregarActivity::class.java)
        startActivity(intent)
    }
}