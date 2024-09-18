package com.example.rick_morty.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Result
import com.example.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val rickAndMortyRepository: RickAndMortyRepository
) : ViewModel() {

    private val _detail=MutableStateFlow<Result?>(null)
    val detail:StateFlow<Result?> get() = _detail

     fun loadData(id:Int) {
         viewModelScope.launch{
             _detail.value=rickAndMortyRepository.getCharacterDetail(id)
         }
    }
}