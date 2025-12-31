package dev.evertonprdo.data

import dev.evertonprdo.core.UniqueEntityId
import dev.evertonprdo.domain.Todo
import dev.evertonprdo.domain.TodoRepository

object InMemoryTodoRepository : TodoRepository {

    private val todos = mutableListOf<Todo>()

    override fun insert(todo: Todo) {
        todos.add(todo)
    }

    override fun get(id: UniqueEntityId): Todo? {
        return todos.find { it.id.id == id.id }
    }

    override fun getAll(): List<Todo> {
        return todos
    }
}