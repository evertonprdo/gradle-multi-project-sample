package dev.evertonprdo.core

class UniqueEntityId(
    val id: Int = generateId()
) {

    private companion object {
        var currentId = 1

        fun generateId(): Int {
            val newId = currentId
            currentId++

            return newId
        }
    }
}