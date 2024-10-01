package com.robertobizzozzero.clase_2_profesor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robertobizzozzero.clase_2_profesor.ui.theme.Clase2profesorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClaseLayout1()
            }
        }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Clase2profesorTheme {
            ClaseLayout1()
        }
    }

    /* ------------------------------------------------------------------------------------- */
    
    @Composable
    fun ClaseLayout1() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
       ) {
            // ----
            // ir descomentando para poder probar las funcionalidades

            //Saludo(nombre = "Android")
            //ColorCambiante()
            //Contador()
            EjemploColumn()
            EjemploRow()
            EjemploBox()

            // ----
        }
    }

    @Composable
    fun Saludo(nombre: String) {
        Text(text = "Hola $nombre")
    }


    @Composable
    fun ColorCambiante() {
        var colorActual by remember { mutableStateOf(Color.Red) }

        Column {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(colorActual)
            )

            Button(onClick = {
                colorActual = when (colorActual) {
                    Color.Red -> Color.Green
                    Color.Green -> Color.Blue
                    else -> Color.Red
                }
            }) {
                Text(text = "Cambiar color")
            }
        }
    }

    @Composable
    fun Contador() {
        var cuenta by remember { mutableStateOf(0) }

        Button(onClick = { cuenta++ }) {
            Text(text = "La cuenta es $cuenta")
        }
    }


    @Composable
    fun EjemploColumn() {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Primer Elemento")
            Text(text = "Segundo Elemento")
            Text(text = "Tercer Elemento")
        }
    }

    @Composable
    fun EjemploRow() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Izquierda")
            Text(text = "Centro")
            Text(text = "Derecha")
        }
    }


    @Composable
    fun EjemploBox() {
        Box(modifier = Modifier.size(100.dp).background(Color.Blue)) {
            Text(
                text = "Primer Plano",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

}