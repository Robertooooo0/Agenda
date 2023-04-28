package com.example.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class AgregarActivity : AppCompatActivity() {
    lateinit var txtNombre: EditText
    lateinit var txtApellido: EditText
    lateinit var txtEdad: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)

        txtNombre = findViewById(R.id.ednombre)
        txtApellido = findViewById(R.id.edapellido)
        txtEdad = findViewById(R.id.edad)
    }

    fun guardar(v: View) {
        val nombre = txtNombre.text.toString()
        val apellido = txtApellido.text.toString()
        val edad = txtEdad.text.toString().toInt()
        val id = Provisional.listaPersona.size
        val persona = Persona(nombre, apellido, edad, id)
        Provisional.listaPersona.add(persona)
        Toast.makeText(this, "Información guardada correctamente", Toast.LENGTH_LONG).show()
        finish()
    }
}
