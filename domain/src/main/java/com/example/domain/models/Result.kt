package com.example.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val created: String?=null,
    val episode: List<String>?= emptyList(),
    val gender: String?=null,
    val id: Int?=null,
    val image: String?=null,
    val location: Location?=null,
    val name: String?=null,
    val origin: Origin?=null,
    val species: String?=null,
    val status: String?=null,
    val type: String?=null,
    val url: String?=null
)