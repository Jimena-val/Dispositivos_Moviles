package com.example.moviles.persistencia

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
@Preview(showBackground = true)
fun ProfileView(){
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf(0) }
    var hasPet by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val preferences = Preferencias(context)
    val corrutina = rememberCoroutineScope()
    //Recuperar los datos
    var nombreGuardado = preferences.name.collectAsState("")
    var mascotaGuardada = preferences.hasPet.collectAsState(false)
    var edadGuardada = preferences.age.collectAsState(0)


    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text="Mi Perfil")
        Text(text="Datos guardados hasta ahora son: ${nombreGuardado.value}, ${edadGuardada.value} y ${mascotaGuardada.value}")
        TextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = { Text(text="Nombre") }
        )
        TextField(
            value = edad.toString(),
            onValueChange = {
                if(it.isNotBlank() && it.toIntOrNull() != null){
                    edad = it.toInt()
                }
            }
        )
        Switch(hasPet, onCheckedChange = {hasPet = it})
        Button(onClick = {
            corrutina.launch {
                preferences.guardarDatosPersonal(edad, nombre, hasPet)
            }
        }) {
            Text(text="Guardar")
        }
    }
}