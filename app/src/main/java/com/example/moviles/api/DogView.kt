package com.example.moviles.api

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage

@Composable

fun DogView(dogViewModel: DogViewModel){

    Column (modifier = Modifier.fillMaxSize()){
        Text(text= "El cachorro de hoy es: ")
        Button(onClick = {
            dogViewModel.traerUrlImagen()
        }) {
            Text(text="Mostrar imagen")
        }
        Text(text= dogViewModel.url)
        if(dogViewModel.url.isNotBlank()){
            AsyncImage(
                model = dogViewModel.url,
                contentDescription = null,
            )
        }
    }
}