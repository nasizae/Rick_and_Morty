package com.example.domain.repository

import com.example.domain.models.Result
interface RickAndMortyRepository {
    suspend fun getCharacters(page:Int):List<Result>
    suspend fun getCharacterDetail(id:Int):Result
}