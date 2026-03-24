package com.example.moviles.corrutinas
import android.util.Log
import android.util.Log.e
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentsViewModel: ViewModel() {
    var isLoading by mutableStateOf(false)
        private set

    var winner by mutableStateOf("")
        private set
    /*var lista= mutableListOf<String>()
    init {
         lista = mutableListOf("Juan", "")
    }
    */
    fun getWinner() {
        isLoading = true
        try {
            viewModelScope.launch {
                winner = ""
                changePerson()
            }
        } catch (e: Exception) {
            Log.e("ERROR_BACKGROUND", "Error en modulo studentsViewModel $e")
        }finally {
            isLoading = false
        }
    }
    suspend fun changePerson() {
        withContext(Dispatchers.IO) {
            isLoading = true
            delay(5000)
            winner = "Juan Perez Perez"
            isLoading = false
        }
    }
}