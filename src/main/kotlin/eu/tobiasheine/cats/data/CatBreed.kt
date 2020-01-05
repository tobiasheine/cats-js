package eu.tobiasheine.cats.data

import kotlinx.serialization.Serializable

@Serializable
data class CatBreed(
    val id: String,
    val name: String
)
