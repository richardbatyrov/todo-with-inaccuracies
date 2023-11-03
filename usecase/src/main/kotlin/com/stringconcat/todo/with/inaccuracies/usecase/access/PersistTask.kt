package com.stringconcat.todo.with.inaccuracies.usecase.access

import com.stringconcat.todo.with.inaccuracies.domain.Task

interface PersistTask {
    fun persist(task: Task)
}