package com.stringconcat.todo.with.inaccuracies.persistance.model


import com.stringconcat.todo.with.inaccuracies.domain.Deadline
import com.stringconcat.todo.with.inaccuracies.domain.Task
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "task")
@Entity
data class TaskEntity(
    @Id val id: UUID,
    val description: String,
    val deadline: LocalDateTime,
    val priority: Priority
) {

    enum class Priority {
        NEED_CALCULATION, LOW, MIDDLE, HIGH
    }

    companion object {
        fun fromBusiness(t: Task): TaskEntity =
            TaskEntity(
                id = t.id,
                description = t.description,
                deadline = t.deadline.value,
                priority = t.priority.toEntity()
            )

        fun toBusiness(t: TaskEntity): Task =
            Task(
                id = t.id,
                description = t.description,
                deadline = Deadline.fromNanoSeconds(t.deadline.toEpochSecond(ZoneOffset.UTC)),
                priority = t.priority.toDomain()
            )
    }
}

// Чтобы обезопасить себя от изменений в доменном Priority
// в домене может добавиться к примеру еще один тип так, что два доменных типа будут маппиться в один жпа тип
// или наоборот, в домене сократится на один тип, и два жпа типа будут маппиться в один доменный
fun Task.Priority.toEntity(): TaskEntity.Priority =
    when(this) {
        Task.Priority.NEED_CALCULATION -> TaskEntity.Priority.NEED_CALCULATION
        Task.Priority.LOW -> TaskEntity.Priority.LOW
        Task.Priority.MIDDLE -> TaskEntity.Priority.MIDDLE
        Task.Priority.HIGH -> TaskEntity.Priority.HIGH
    }

fun TaskEntity.Priority.toDomain(): Task.Priority =
    when(this) {
        TaskEntity.Priority.NEED_CALCULATION -> Task.Priority.NEED_CALCULATION
        TaskEntity.Priority.LOW -> Task.Priority.LOW
        TaskEntity.Priority.MIDDLE -> Task.Priority.MIDDLE
        TaskEntity.Priority.HIGH -> Task.Priority.HIGH
    }
