package com.example.domain.models

import kotlinx.serialization.Serializable


@Serializable
data class Character(
    val info: Info,
    val results: List<Result>
)