/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lemonade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

/**
 * Clase principal
 * Creamos un objeto ImageView y otro TextView
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagen: ImageView = findViewById(R.id.image_lemon_state)
        val texto: TextView = findViewById(R.id.text_action)

        cogerLimon(imagen, texto)
    }


}

/**
 * Metodo que recibe una imagen y un texto. Les da valor
 * Al pulsar en la imagen, cogemos un limon
 */
private fun cogerLimon(imagen: ImageView, texto: TextView) {
    texto.setText("Coge un limon")
    imagen.setImageResource(R.drawable.lemon_tree)

    imagen.setOnClickListener {
        exprimirLimon(imagen, texto)
    }
}

/**
 * Metodo que recibe una imagen y un texto. Les da valor
 * Al pulsar la imagen, exprimimos el limon hasta llegar al limite
 */
private fun exprimirLimon(imagen: ImageView, texto: TextView) {
    texto.setText("Pulsa para exprimir el limon")
    imagen.setImageResource(R.drawable.lemon_squeeze)
    val exprimir: Int = (1..6).random()
    var exprimido: Int = 1

    imagen.setOnClickListener {
        if (exprimido == exprimir) beberLimonada(imagen, texto)
        else Snackbar.make(
            imagen,
            "Has exprimido el limon $exprimido " + if (exprimido == 1) " vez" else " veces",
            Snackbar.LENGTH_SHORT
        ).show()
        exprimido++


    }

    imagen.setOnLongClickListener {
        if (exprimido == exprimir) beberLimonada(imagen, texto)
        else Snackbar.make(
            imagen,
            "Has exprimido el limon $exprimido " + if (exprimido == 1) "vez" else "veces",
            Snackbar.LENGTH_SHORT
        ).show()
        exprimido++

        true
    }
}

/**
 * Metodo que recibe una imagen y un texto. Les da valor
 * Al pulsar en la imagen, bebemos la limonada
 */
private fun beberLimonada(imagen: ImageView, texto: TextView) {
    texto.setText("Pulsa para beber la limonada")
    imagen.setImageResource(R.drawable.lemon_drink)

    imagen.setOnClickListener {
        llenarVaso(imagen, texto)
    }
}

/**
 * Metodo que recibe una imagen y un texto. Les da valor
 * Al pulsar en la imagen rellenamos el vaso cogiendo un limon
 */
private fun llenarVaso(imagen: ImageView, texto: TextView) {
    texto.setText("Pulsa para llenar el vaso")
    imagen.setImageResource(R.drawable.lemon_restart)

    imagen.setOnClickListener {
        cogerLimon(imagen, texto)
    }
}
