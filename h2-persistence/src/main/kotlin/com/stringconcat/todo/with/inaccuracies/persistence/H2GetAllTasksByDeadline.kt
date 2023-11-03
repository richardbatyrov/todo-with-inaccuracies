package com.stringconcat.todo.with.inaccuracies.persistence

import com.stringconcat.todo.with.inaccuracies.domain.Task
import com.stringconcat.todo.with.inaccuracies.persistance.GetAllByDeadline
import com.stringconcat.todo.with.inaccuracies.persistance.model.TaskEntity
import com.stringconcat.todo.with.inaccuracies.persistance.repository.TaskRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class H2GetAllTasksByDeadline(
    private val repository: TaskRepository
) : GetAllByDeadline {

    override fun invoke(deadline: LocalDateTime): List<Task> =
        repository
            .findAllByDeadline(deadline)
            .map { t -> TaskEntity.toBusiness(t) }.toList()
}