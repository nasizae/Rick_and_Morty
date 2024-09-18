package com.example.rick_morty.di.modul

import com.example.data.network.RickAndMortyApiService
import com.example.data.repository.CharacterRepositoryImpl
import com.example.domain.repository.RickAndMortyRepository
import com.example.rick_morty.ui.viewModels.CharacterViewModel
import com.example.rick_morty.ui.viewModels.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<RickAndMortyApiService> { RickAndMortyApiService() }
    single<RickAndMortyRepository> { CharacterRepositoryImpl(get()) }
    viewModel { CharacterViewModel(get()) }
    viewModel {DetailViewModel(get())}
}