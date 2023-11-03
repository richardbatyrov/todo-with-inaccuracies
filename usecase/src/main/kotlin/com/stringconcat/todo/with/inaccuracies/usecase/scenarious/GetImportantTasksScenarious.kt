package com.stringconcat.todo.with.inaccuracies.usecase.scenarious

import com.stringconcat.todo.with.inaccuracies.domain.Task
import com.stringconcat.todo.with.inaccuracies.persistance.GetAllByPriority
import com.stringconcat.todo.with.inaccuracies.usecase.GetImportantTasksUseCase
import com.stringconcat.todo.with.inaccuracies.usecase.dto.TaskResponse
import com.stringconcat.todo.with.inaccuracies.usecase.dto.toTaskResponses
import javax.inject.Named

@Named
class GetImportantTasksScenarious(
    private val getTasks: GetAllByPriority,
) : GetImportantTasksUseCase {

    override fun process(): List<TaskResponse> {
        return getTasks(Task.Priority.HIGH).toTaskResponses()
    }
}