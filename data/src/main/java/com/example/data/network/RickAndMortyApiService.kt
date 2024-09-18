package com.example.data.network

import com.example.domain.models.Character
import com.example.domain.models.Result
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class RickAndMortyApiService {
    private val client = HttpClient(CIO){
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun fetchCharacters(page: Int): Character {
        return client.get("https://rickandmortyapi.com/api/character?$page").body<Character>()
    }

    suspend fun fetchCharacterDetail(id: Int): Result {
        return client.get("https://rickandmortyapi.com/api/character/$id").body<Result>()
    }


}

