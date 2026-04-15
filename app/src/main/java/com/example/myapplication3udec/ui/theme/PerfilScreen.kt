package com.example.myapplication3udec.ui

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

@Composable
fun PerfilScreen(viewModel: PerfilViewModel) {

    val perfil = viewModel.perfil

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // 🔹 Header
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    AsyncImage(
                        model = perfil.imagen,
                        contentDescription = "Foto de perfil",
                        modifier = Modifier
                            .size(130.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = perfil.nombre,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        text = "${perfil.programa} - Semestre ${perfil.semestre}",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = perfil.descripcion,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        // 🔥 Secciones expandibles
        item {
            ExpandableCard("Información Personal") {
                Text("Edad: ${perfil.edad}")
                Text("Ciudad: ${perfil.ciudad}")
                Text("Correo: ${perfil.correo}")
            }
        }

        item {
            ExpandableCard("Hobbies") {
                perfil.hobbies.forEach { Text("• $it") }
            }
        }

        item {
            ExpandableCard("Pasatiempos") {
                perfil.pasatiempos.forEach { Text("• $it") }
            }
        }

        item {
            ExpandableCard("Deportes") {
                perfil.deportes.forEach { Text("• $it") }
            }
        }

        item {
            ExpandableCard("Intereses") {
                perfil.intereses.forEach { Text("• $it") }
            }
        }
    }
}

@Composable
fun ExpandableCard(
    titulo: String,
    contenido: @Composable ColumnScope.() -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = titulo,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(if (expanded) "▲" else "▼")
            }

            if (expanded) {
                Spacer(modifier = Modifier.height(10.dp))
                contenido()
            }
        }
    }
}