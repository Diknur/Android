package com.example.quisandroid_muhamadsidik.network

import com.example.quisandroid_muhamadsidik.model.character
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.HttpURLConnection
import java.net.URL

object ApiService {
    fun fetchCharacters(): List<Character>? {
        val url = URL("https://rickandmortyapi.com/api/character")
        val connection = url.openConnection() as HttpURLConnection

        return try {
            connection.requestMethod = "GET"
            connection.inputStream.bufferedReader().use { reader ->
                val response = reader.readText()
                val responseType = object : TypeToken<ApiResponse<Character>>() {}.type
                val apiResponse: ApiResponse<Character> = Gson().fromJson(response, responseType)
                apiResponse.results
            }
        } finally {
            connection.disconnect()
        }
    }

    data class ApiResponse<T>(
        val info: Info,
        val results: List<T>
    )

    data class Info(
        val count: Int,
        val pages: Int,
        val next: String?,
        val prev: String?
    )
}