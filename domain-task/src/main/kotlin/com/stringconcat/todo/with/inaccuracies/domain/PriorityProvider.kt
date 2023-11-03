package com.stringconcat.todo.with.inaccuracies.domain

interface PriorityProvider {
    fun calculatePriority(task: Task): Task.Priority
}
