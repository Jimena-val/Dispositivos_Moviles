package com.example.moviles.persistencia

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)
fun ProfileView(){
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf(0) }
    var hasPet by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text="Mi Perfil")
        TextField(
            value = nombre,
            onValueChange = {},
            label = { Text(text="Nombre") }
        )
        TextField(
            value = edad.toString(),
            onValueChange = {},
            label = { Text(text="Nombre") }
        )
        Switch(hasPet, onCheckedChange = {hasPet = it})
    }
}