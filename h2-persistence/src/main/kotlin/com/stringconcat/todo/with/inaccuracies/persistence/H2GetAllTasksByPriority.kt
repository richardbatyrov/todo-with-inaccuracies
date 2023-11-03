package com.stringconcat.todo.with.inaccuracies.persistence

import com.stringconcat.todo.with.inaccuracies.domain.Task
import com.stringconcat.todo.with.inaccuracies.persistance.GetAllByDeadline
import com.stringconcat.todo.with.inaccuracies.persistance.GetAllByPriority
import com.stringconcat.todo.with.inaccuracies.persistance.model.TaskEntity
import com.stringconcat.todo.with.inaccuracies.persistance.repository.TaskRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class H2GetAllTasksByPriority(
    private val repository: TaskRepository
) : GetAllByPriority {
    override fun invoke(priority: Task.Priority): List<Task> =
        repository
            .findAllByPriority(priority)
            .map { t -> TaskEntity.toBusiness(t) }.toList()
}