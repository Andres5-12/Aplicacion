package com.example.myapplication3udec.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication3udec.R
import com.example.myapplication3udec.model.Perfil

class PerfilViewModel : ViewModel() {

    // 🔹 Estado para mostrar u ocultar información
    var mostrarInfo = mutableStateOf(false)
        private set

    // 🔹 Datos del perfil
    private val _perfil = Perfil(
        nombre = "Kevin Andres Corredor",
        edad = 20,
        ciudad = "Bogotá",
        correo = "kevin@email.com",
        descripcion = "Estudiante de Ingeniería de Software apasionado por la tecnología y el desarrollo de aplicaciones.",
        programa = "Ingeniería de Software",
        semestre = 5,
        hobbies = listOf("Programar", "Leer", "Aprender nuevas tecnologías"),
        pasatiempos = listOf("Videojuegos", "Escuchar música", "Ver series"),
        deportes = listOf("Fútbol", "Ciclismo"),
        intereses = listOf("Robótica", "Inteligencia Artificial", "Desarrollo móvil"),
        imagen = "https://i.pinimg.com/736x/6f/93/b3/6f93b317a0ad5ec8c3d38b5c69e9ae44.jpg"
    )

    // 🔹 Exponer el perfil (solo lectura)
    val perfil: Perfil
        get() = _perfil

    // 🔹 Función para mostrar/ocultar información
    fun toggleInfo() {
        mostrarInfo.value = !mostrarInfo.value
    }

    // 🔹 (Opcional) Reiniciar estado
    fun ocultarInfo() {
        mostrarInfo.value = false
    }
}