package dev.evertonprdo

import dev.evertonprdo.data.InMemoryTodoRepository
import dev.evertonprdo.domain.GetAllTodos
import dev.evertonprdo.domain.GetReport
import dev.evertonprdo.domain.GetTodo
import dev.evertonprdo.domain.InsertTodo
import dev.evertonprdo.report.ReportController
import dev.evertonprdo.task.TodoController

fun main() {
    val taskController = TodoController(
        getAllTodos = GetAllTodos(InMemoryTodoRepository),
        insertTodo = InsertTodo(InMemoryTodoRepository),
        getTodo = GetTodo(InMemoryTodoRepository)
    )

    val reportController = ReportController(
        getReport = GetReport(InMemoryTodoRepository)
    )

    taskController.listTodos()

    taskController.newTodo("Something todo")
    taskController.newTodo("Another thing")

    taskController.listTodos()

    taskController.printTodo(1)
    taskController.printTodo(2)
    taskController.printTodo(3)

    reportController.printReport()
}