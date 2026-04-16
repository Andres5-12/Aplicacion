package com.example.myapplication3udec.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import com.example.myapplication3udec.model.Perfil
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.draw.border
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication3udec.viewmodel.PerfilViewModel
import androidx.compose.foundation.lazy.grid.*

@Composable
fun PerfilScreen(viewModel: PerfilViewModel) {

    val perfil = viewModel.perfil
    val mostrarInfo = viewModel.mostrarInfo.value

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        // Header
        item {
            HeaderPerfil(perfil)
        }

        // Descripción
        item {
            Text(
                text = perfil.descripcion,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }

        // Botón
        item {
            OutlinedButton(
                onClick = { viewModel.toggleInfo() },
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    if (mostrarInfo)
                        "Ocultar información"
                    else
                        "Ver información personal"
                )
            }
        }

        item { Spacer(modifier = Modifier.height(12.dp)) }
        // Info personal
        if (mostrarInfo) {
            item {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        InfoItem(Icons.Default.LocationOn, "Ciudad", perfil.ciudad)
                        InfoItem(Icons.Default.Email, "Correo", perfil.correo)
                        InfoItem(Icons.Default.Person, "Edad", "${perfil.edad}")
                    }
                }
            }
        }

        //  Tabs
        item {
            TabsIntereses(perfil)
        }
    }
}

@Composable
fun HeaderPerfil(perfil: Perfil) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF1E1E2C), Color(0xFF2A2A40))
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = perfil.imagen,
                contentDescription = null,
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
                    .border(3.dp, Color.White, CircleShape)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(perfil.nombre, color = Color.White)

            Text(perfil.programa, color = Color.LightGray)

            Text("Semestre ${perfil.semestre}", color = Color.White)
        }
    }
}

@Composable
fun InfoItem(icon: ImageVector, label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null)
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(label)
            Text(value)
        }
    }
}


@Composable
fun GridIntereses(lista: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        items(lista.size) { i ->
            Card(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    lista[i],
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun TabsIntereses(perfil: Perfil) {

    var selectedTab by remember { mutableStateOf(0) }

    val tabs = listOf("Hobbies", "Pasatiempos", "Deportes", "Intereses")

    Column {

        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }

        when (selectedTab) {
            0 -> GridIntereses(perfil.hobbies)
            1 -> GridIntereses(perfil.pasatiempos)
            2 -> GridIntereses(perfil.deportes)
            3 -> GridIntereses(perfil.intereses)
        }
    }
}