package com.example.spendy.database

import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

class SupabaseClientHelper {



    // Метод для получения данных (например, пользователей)
    fun getUsers(): List<String> {
        return runBlocking {
            try {
                val response = client
                    .from("users") // Таблица "users"
                    .select()
                    .execute()

                response.data?.map { it["name"].toString() } ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
                emptyList()
            }
        }
    }
}
