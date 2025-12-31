package dev.evertonprdo.domain

class InsertTodo(
    private val todoRepository: TodoRepository
) {

    operator fun invoke(description: String) {
        val todo = Todo(description)
        todoRepository.insert(todo)
    }
}