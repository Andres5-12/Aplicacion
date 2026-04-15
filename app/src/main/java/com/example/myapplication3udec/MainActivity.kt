package com.example.myapplication3udec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplication3udec.ui.PerfilScreen
import com.example.myapplication3udec.viewmodel.PerfilViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val viewModel = PerfilViewModel()

            PerfilScreen(viewModel)

        }
    }
}