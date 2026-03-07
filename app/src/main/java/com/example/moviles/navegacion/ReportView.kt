package com.example.moviles.navegacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
//@Preview(showBackground = true)
fun ReportView(navegante: NavHostController) {
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
    }
}