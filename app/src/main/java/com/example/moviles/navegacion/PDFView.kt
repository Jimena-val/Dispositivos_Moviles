package com.example.moviles.navegacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PDFView (generarreporte : ReportModel = ReportModel(numeroseccion = 1, nombreencargado = "juan", nombreseccion = "pollo")){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text= "Nombre de la sección: ${generarreporte.nombreseccion}")
        Text(text = "Numero de la sección: ${generarreporte.numeroseccion}")
        Text(text= "Nombre del encargado: ${generarreporte.nombreencargado}")
    }
}
@Preview(showBackground = true)
@Composable
fun PDFPreview(){
    val reporte = ReportModel(numeroseccion = 1, nombreencargado = "Jose", nombreseccion = "ISND")
    PDFView(generarreporte = reporte)
}