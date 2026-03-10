package com.example.moviles.navegacion

import android.content.ContentValues
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
//@Preview(showBackground = true)
fun ReportView(navegante: NavHostController) {
    var nombreseccion by remember { mutableStateOf("") }
    var numeroseccion by remember { mutableStateOf("") }
    var nombreencargado by remember { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Reporte de ventas")
        Button(onClick = {
            navegante.popBackStack() //desaparece la vista acutal y regresa a la anterior de la pila
        }) {
            Text(text = "Regresar")
        }
        TextField(
            value = nombreseccion,
            onValueChange = {nombreseccion = it},
            label = {Text("Nombre de la sección")},
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )
        TextField(
            value = numeroseccion,
            onValueChange = {numeroseccion = it},
            label = {Text("Numero de la sección")},
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )
        TextField(
            value = nombreencargado,
            onValueChange = {nombreencargado = it},
            label = {Text("Nombre del encargado")},
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        )
        Button(onClick= {
            navegante.navigate(ReportModel(
                nombreseccion.trim(),
                numeroseccion.toInt(),
                nombreencargado
            ))
        }){
            Text(text = "Enviar datos")
        }
    }
}