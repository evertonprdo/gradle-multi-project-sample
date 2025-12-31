package dev.evertonprdo.domain

class GetReport(
    private val todoRepository: TodoRepository
) {

    operator fun invoke(): Int {
        return todoRepository.getAll().size
    }
}