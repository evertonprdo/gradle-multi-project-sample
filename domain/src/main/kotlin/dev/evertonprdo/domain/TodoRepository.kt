package dev.evertonprdo.domain

import dev.evertonprdo.core.UniqueEntityId

interface TodoRepository {
    fun insert(todo: Todo)
    fun get(id: UniqueEntityId): Todo?
    fun getAll(): List<Todo>
}