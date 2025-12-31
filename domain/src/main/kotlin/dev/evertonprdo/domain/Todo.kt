package dev.evertonprdo.domain

import dev.evertonprdo.core.UniqueEntityId

data class Todo(
    val description: String,
    val id: UniqueEntityId = UniqueEntityId()
)
