package com.example.rick_morty.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.models.Result
import com.example.domain.repository.RickAndMortyRepository
import com.example.rick_morty.paging.CharacterPagingSource
import kotlinx.coroutines.flow.Flow

class CharacterViewModel(
    private val characterRepository: RickAndMortyRepository
) : ViewModel() {

    val characters: Flow<PagingData<Result>> = Pager(PagingConfig(pageSize = 20)) {
        CharacterPagingSource(characterRepository)
    }.flow.cachedIn(viewModelScope)

}