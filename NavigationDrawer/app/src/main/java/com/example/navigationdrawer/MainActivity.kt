package com.example.navigationdrawer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationdrawer.ui.theme.NavigationDrawerTheme
import kotlinx.coroutines.launch
import java.util.logging.LogManager

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mostrarContenido()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun mostrarContenido() {

    // Variable que recuerda en qué estado se encuentra el menú (abierto o cerrado)
    val estadoMenu = rememberDrawerState(initialValue = DrawerValue.Closed)

    // Corutina de tipo remember (es un hilo de ejecución) para mostrar u ocultar
    val accionMovimiento = rememberCoroutineScope()

    // El índice del elemento del menú que está seleccionado
    var elementoActual by remember() {
        mutableStateOf(0)
    }

    // NavController
    val controladorNavegacion = rememberNavController()

    var almacen=Almacen()

    // Composables de las pantallas a las que podremos ir
    NavHost(navController = controladorNavegacion, startDestination = "pantalla1") {
        composable("pantalla1") {
            Pantalla1(almacen.productosAlmacenados)
        }
        composable("pantalla2") {
            Pantalla2(almacen.productosAlmacenados)
        }
        composable("pantalla3") {
            Pantalla3(almacen.productosAlmacenados)
        }
        composable("pantalla4") {
            Pantalla4(almacen.productosAlmacenados)
        }
        composable("pantalla5") {
            Pantalla5(almacen.productosAlmacenados)
        }
        composable("pantalla6") {
            Pantalla6(almacen.productosAlmacenados)
        }
    }

    // MENÚ LATERAL
    // Incluye el contenedor de la pantalla. Añade un Scaffold con el header, contenido y footer
    ModalNavigationDrawer(
        drawerState = estadoMenu, // abierto o cerrado
        drawerContent = { // contenido del menú
            ModalDrawerSheet {
                // Título del menú lateral
                ListItem(
                    headlineText = { Text("Título del menú") },
                    // Icono del menú
                    leadingContent = {
                        IconButton(onClick = {
                            accionMovimiento.launch { estadoMenu.close() }
                        }) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                )
                Divider()
                // Elemento de menú
                NavigationDrawerItem(
                    label = { Text(text = "Hogar") },
                    selected = (elementoActual == 0),
                    onClick = {
                        accionMovimiento.launch { estadoMenu.close() }
                        elementoActual = 0
                        controladorNavegacion.navigate("pantalla1")
                    }
                )
                // Elemento de menú
                NavigationDrawerItem(
                    label = { Text(text = "Electronica") },
                    selected = (elementoActual == 1),
                    onClick = {
                        accionMovimiento.launch { estadoMenu.close() }
                        elementoActual = 1
                        controladorNavegacion.navigate("pantalla2")
                    }
                )
                // Elemento de menú
                NavigationDrawerItem(
                    label = { Text(text = "Ropa") },
                    selected = (elementoActual == 2),
                    onClick = {
                        accionMovimiento.launch { estadoMenu.close() }
                        elementoActual = 2
                        controladorNavegacion.navigate("pantalla2")
                    }
                )
                // Elemento de menú
                NavigationDrawerItem(
                    label = { Text(text = "Cocina") },
                    selected = (elementoActual == 3),
                    onClick = {
                        accionMovimiento.launch { estadoMenu.close() }
                        elementoActual = 3
                        controladorNavegacion.navigate("pantalla2")
                    }
                )
                // Elemento de menú
                NavigationDrawerItem(
                    label = { Text(text = "Juguetes") },
                    selected = (elementoActual == 4),
                    onClick = {
                        accionMovimiento.launch { estadoMenu.close() }
                        elementoActual = 4
                        controladorNavegacion.navigate("pantalla2")
                    }
                )
                // Elemento de menú
                NavigationDrawerItem(
                    label = { Text(text = "Decoracion") },
                    selected = (elementoActual == 5),
                    onClick = {
                        accionMovimiento.launch { estadoMenu.close() }
                        elementoActual = 5
                        controladorNavegacion.navigate("pantalla2")
                    }
                )
            }
        },
    ) {
        //////////////////////////////////////
        ///// CONTENIDO DE LA PANTALLA ///////
        //////////////////////////////////////
        Scaffold(
            // Barra superior de navegación
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Tienda Regalos")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            accionMovimiento.launch { estadoMenu.open() }
                        }) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column( // CONTENIDO PRINCIPAL
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when(elementoActual){
                    0 -> Pantalla1(almacen.productosAlmacenados)
                    1 -> Pantalla2(almacen.productosAlmacenados)
                    2 -> Pantalla3(almacen.productosAlmacenados)
                    3 -> Pantalla4(almacen.productosAlmacenados)
                    4 -> Pantalla5(almacen.productosAlmacenados)
                    5 -> Pantalla6(almacen.productosAlmacenados)
                }
            }
        }
    }
}



