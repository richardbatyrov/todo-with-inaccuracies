package com.stringconcat.todo.with.inaccuracies.usecase.scenarious

import com.stringconcat.todo.with.inaccuracies.domain.Task
import com.stringconcat.todo.with.inaccuracies.domain.PriorityProvider
import com.stringconcat.todo.with.inaccuracies.usecase.CreateNewTaskUseCase
import com.stringconcat.todo.with.inaccuracies.domain.TaskRequest
import com.stringconcat.todo.with.inaccuracies.usecase.access.PersistTask
import com.stringconcat.todo.with.inaccuracies.usecase.dto.TaskResponse
import com.stringconcat.todo.with.inaccuracies.usecase.dto.toTaskResponse
import javax.inject.Named

@Named
class CreateNewTaskScenario(
    private val persistTask: PersistTask,
    private val priorityProvider: PriorityProvider
) : CreateNewTaskUseCase {
    override operator fun invoke(taskRequest: TaskRequest): TaskResponse {
        val createdTask = Task.create(taskRequest, priorityProvider)
        persistTask.persist(createdTask)
        return createdTask.toTaskResponse()
    }
}