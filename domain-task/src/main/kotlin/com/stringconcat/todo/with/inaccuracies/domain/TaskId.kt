package com.stringconcat.todo.with.inaccuracies.domain

import java.util.UUID

class TaskId(val value: UUID) {

    init {
        require(value != UUID(0, 0)) { "id must be positive" }
    }
}