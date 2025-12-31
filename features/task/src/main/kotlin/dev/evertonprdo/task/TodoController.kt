package dev.evertonprdo.task

import dev.evertonprdo.domain.GetAllTodos
import dev.evertonprdo.domain.GetTodo
import dev.evertonprdo.domain.InsertTodo

class TodoController(
    private val getAllTodos: GetAllTodos,
    private val getTodo: GetTodo,
    private val insertTodo: InsertTodo
) {

    fun listTodos() {
        val todos = getAllTodos()
        if (todos.isEmpty())
            return println("NO TODOS HAVE BEEN REGISTERED YET")

        todos.forEach {
            println(
                """
                    ----------------------------------
                    
                        TODO #${it.id.id}
                        DESCRIPTION: ${it.description}
                        
                """.trimIndent()
            )
        }
        println("----------------------------------")
    }

    fun newTodo(description: String) {
        insertTodo(description)
        println("TODO INSERTED SUCCESSFULLY")
    }

    fun printTodo(id: Int) {
        getTodo(id)?.let {
            println(
                """
                    ----------------------------------
                    
                        TODO #${it.id.id}
                        DESCRIPTION: ${it.description}
                        
                    ----------------------------------
                """.trimIndent()
            )
        } ?: println("404: RESOURCE NOT FOUND")
    }
}