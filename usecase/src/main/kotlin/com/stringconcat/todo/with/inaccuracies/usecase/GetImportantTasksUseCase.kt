package com.stringconcat.todo.with.inaccuracies.usecase

import com.stringconcat.todo.with.inaccuracies.usecase.dto.TaskResponse

interface GetImportantTasksUseCase {
    fun process() : List<TaskResponse>
}