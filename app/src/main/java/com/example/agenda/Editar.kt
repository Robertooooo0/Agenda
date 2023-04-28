package com.example.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Editar : AppCompatActivity() {

    lateinit var edNombre: EditText
    lateinit var edApellido: EditText
    lateinit var edEdad: EditText

    var posicion=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar)

        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val edad = intent.getIntExtra("edad", 0)
        val id = intent.getIntExtra("id",0)
        posicion = id

        edNombre = findViewById(R.id.edNombre)
        edApellido = findViewById(R.id.edapellido)
        edEdad = findViewById(R.id.ededad)

        edNombre.setText(nombre)
        edApellido.setText(apellido)
        edEdad.setText(edad.toString())
    }

    fun guardarCambios(v: View) {
        val nuevoNombre = edNombre.text.toString()
        val nuevoApellido = edApellido.text.toString()
        val nuevaEdad = edEdad.text.toString().toInt()

        val listaPersona = Provisional.listaPersona
        val persona = listaPersona[posicion]
        val nuevaPersona = Persona(nuevoNombre, nuevoApellido, nuevaEdad, persona.id)
        listaPersona[posicion] = nuevaPersona

        Toast.makeText(this, "Cambios guardados correctamente", Toast.LENGTH_LONG).show()
        finish()
    }
}
