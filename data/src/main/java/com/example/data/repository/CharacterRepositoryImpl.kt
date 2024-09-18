package com.example.data.repository

import com.example.data.network.RickAndMortyApiService
import com.example.domain.models.Result
import com.example.domain.repository.RickAndMortyRepository

class CharacterRepositoryImpl(
    private val apiService: RickAndMortyApiService
) : RickAndMortyRepository {
    override suspend fun getCharacters(page:Int): List<Result> {
        return apiService.fetchCharacters(page).results
    }

    override suspend fun getCharacterDetail(id: Int): Result {
        return apiService.fetchCharacterDetail(id)
    }
}