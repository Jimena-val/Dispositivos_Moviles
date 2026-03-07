package com.example.moviles.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviles.R
import com.example.moviles.lisas.ProductModel

@Preview(showBackground = true)
@Composable
fun ProductPreview(){
    val computadora = ProductModel(imagen = R.drawable.alien, nombre = "Alienware 16 Aurora", descriptor = "Laptop AC16250", calificacion = 4.4f, precio = 31299, fecha = "Llega el viernes")
    ProductView(producto = computadora){

    }
}
@Composable
fun ProductView(producto: ProductModel, selected:()-> Unit){ //selected:() -> Unit se usa para declarar que está ocurriendo un evento
    var textocarrito by remember { mutableStateOf("") }

    Card(modifier = Modifier.fillMaxWidth().padding(10.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row() {
                Image(painter = painterResource(producto.imagen),
                    contentDescription = "imagen de producto",
                    modifier = Modifier.size(120.dp).align(Alignment.CenterVertically)
                )
                Column(modifier = Modifier.padding(5.dp)) {
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(producto.nombre, fontSize = 20.sp)
                    Text(producto.descriptor, fontSize = 17.sp)
                    Text(text = "${producto.calificacion}", fontSize = 14.sp, fontWeight = FontWeight.Light)
                    Text("$${producto.precio}precio", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text(producto.fecha)
                    Spacer(modifier = Modifier.size(10.dp))
                    Button(onClick = {selected()
                        //agregar al carrito y quitar del carrito
                        if (textocarrito == "Producto agregado al carrito"){
                            textocarrito = "El producto se eliminó del carrito"
                        }else  {
                            textocarrito = "Producto agregado al carrito"
                        }
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.Black)) {Text("Agregar al carrito", color = Color.White)
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(textocarrito)
                }
            }
        }
    }
}