package com.stringconcat.todo.with.inaccuracies.usecase

import com.stringconcat.todo.with.inaccuracies.domain.TaskRequest
import com.stringconcat.todo.with.inaccuracies.usecase.dto.TaskResponse

interface CreateNewTaskUseCase {
    fun invoke(taskRequest: TaskRequest): TaskResponse
}