package com.stringconcat.todo.with.inaccuracies.domain

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

data class Task(
    val id: UUID = UUID.randomUUID(),
    val description: String,
    val deadline: Deadline,
    var priority: Priority = Priority.NEED_CALCULATION
) {
    enum class Priority {
        NEED_CALCULATION, LOW, MIDDLE, HIGH
    }

    companion object {
        fun create(taskRequest: TaskRequest, priorityProvider: PriorityProvider): Task = Task(
            description = taskRequest.description,
            deadline = Deadline.fromNanoSeconds(taskRequest.deadline)
        ).also {
            val priority = priorityProvider.calculatePriority(it)
            it.priority = priority
        }
    }
}
