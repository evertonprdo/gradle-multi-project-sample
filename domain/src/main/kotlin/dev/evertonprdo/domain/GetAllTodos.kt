package dev.evertonprdo.domain

class GetAllTodos(
    private val todoRepository: TodoRepository
) {

    operator fun invoke(): List<Todo> {
        return todoRepository.getAll()
    }
}