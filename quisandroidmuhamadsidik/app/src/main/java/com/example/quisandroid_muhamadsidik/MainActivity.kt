package com.example.quisandroid_muhamadsidik

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quisandroid_muhamadsidik.network.ApiService

fun main() {
    val characters = ApiService.fetchCharacters()
    characters?.forEach { character ->
        println("Character: ${character.name}, Status: ${character.status}, Species: ${character.species}")
    }
}