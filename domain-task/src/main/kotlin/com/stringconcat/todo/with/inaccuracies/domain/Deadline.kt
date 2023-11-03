package com.stringconcat.todo.with.inaccuracies.domain

import java.time.LocalDateTime
import java.time.ZoneOffset

class Deadline private constructor(nanoSeconds: Long) {

    val value = LocalDateTime.ofEpochSecond(nanoSeconds, 0, ZoneOffset.UTC)

    init {
        require(nanoSeconds > 0) { "deadline must be positive" }
    }

    companion object {
        fun fromNanoSeconds(value: Long): Deadline {
            return Deadline(value)
        }
    }
}