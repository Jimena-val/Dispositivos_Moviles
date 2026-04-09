package com.example.moviles.api

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)

fun DogView(){
    Column (modifier = Modifier.fillMaxSize()){
        Text(text= "El cachorro de hoy es: ")
        Button(onClick = {
            dogViewModel.traerUrlImagen()
        }) {
            Text(text="Mostrar imagen")
        }
        Text(text= dogViewModel.url)
    }
}