package dev.evertonprdo.domain

import dev.evertonprdo.core.UniqueEntityId

class GetTodo(
    private val todoRepository: TodoRepository
) {

    operator fun invoke(id: Int): Todo? {
        return todoRepository.get(UniqueEntityId(id))
    }
}