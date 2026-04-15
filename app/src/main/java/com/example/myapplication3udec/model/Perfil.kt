package com.example.myapplication3udec.model

data class Perfil(
    val nombre: String,
    val edad: Int,
    val ciudad: String,
    val correo: String,
    val descripcion: String,
    val programa: String,
    val semestre: Int,
    val hobbies: List<String>,
    val pasatiempos: List<String>,
    val deportes: List<String>,
    val intereses: List<String>,
    val imagen: String
)