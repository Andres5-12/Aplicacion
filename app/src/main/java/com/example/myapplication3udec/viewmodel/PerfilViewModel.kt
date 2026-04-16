package com.example.myapplication3udec.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication3udec.R
import com.example.myapplication3udec.model.Perfil

class PerfilViewModel : ViewModel() {

    //  Estado para mostrar u ocultar información
    var mostrarInfo = mutableStateOf(false)
        private set

    //  Datos del perfil
    private val _perfil = Perfil(
        nombre = "Kevin Andres Corredor",
        edad = 20,
        ciudad = "Sesquilé",
        correo = "kacorredor@ucundinamarca.edu.co",
        descripcion = "Estudiante de Ingeniería de Sistemas y computación apasionado por la tecnología, el arte, los videojuegos y la música.",
        programa = "Ingeniería de Sistemas y Computación",
        semestre = 6,
        hobbies = listOf("Dibujar, Jugar videojuegos, Músico "),
        pasatiempos = listOf("Videojuegos", "Escuchar música", "Ver series"),
        deportes = listOf("Fútbol", "Ciclismo, Gimnasio"),
        intereses = listOf("Arte","Futbol","Deportes" ,"Inteligencia Artificial", "Cine"),
        imagen = "https://i.pinimg.com/736x/6f/93/b3/6f93b317a0ad5ec8c3d38b5c69e9ae44.jpg"
    )

    //  Exponer el perfil
    val perfil: Perfil
        get() = _perfil

    //  Función para mostrar/ocultar información
    fun toggleInfo() {
        mostrarInfo.value = !mostrarInfo.value
    }

    //  Reiniciar estado
    fun ocultarInfo() {
        mostrarInfo.value = false
    }
}