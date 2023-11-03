package com.stringconcat.todo.with.inaccuracies.usecase.dto

import com.stringconcat.todo.with.inaccuracies.domain.Task
import java.time.LocalDateTime
import java.util.*

data class TaskResponse(
    val id: UUID = UUID.randomUUID(),
    val description: String,
    val deadline: LocalDateTime,
    var priority: Task.Priority = Task.Priority.NEED_CALCULATION
)

internal fun Task.toTaskResponse(): TaskResponse = TaskResponse(
    id = id,
    description = description,
    deadline = deadline.value,
    priority = priority
)

internal fun List<Task>.toTaskResponses(): List<TaskResponse> = this.map { it.toTaskResponse() }