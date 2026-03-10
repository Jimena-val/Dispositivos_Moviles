package com.example.moviles.navegacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object Report

@Serializable
data class ReportModel(val nombreseccion: String, val numeroseccion: Int, val nombreencargado: String)

@Composable
@Preview(showBackground = true)

fun NavManager() {
    val navcontroler = rememberNavController()
    NavHost(navcontroler, startDestination = Home, modifier = Modifier.padding(innerPadding)){
        composable<Home> {
            HomeView(navcontroler)
        }
        composable<Report> {
            ReportView(navcontroler)
        }
        composable<ReportModel> {
            val datos : ReportModel = it.toRoute()
            PDFView(datos)
        }
    }
}
