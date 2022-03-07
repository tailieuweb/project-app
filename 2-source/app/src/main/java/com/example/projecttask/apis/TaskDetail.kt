package com.example.projecttask.apis

data class TaskDetail(
    val assignee_id: Int,
    val created_at: Any,
    val created_user_id: Any,
    val deleted_at: Any,
    val id: Int,
    val notes: Any,
    val sequence: Any,
    val status: Any,
    val tasks: Task,
    val task_id: Int,
    val updated_at: String,
    val updated_user_id: Any,
    val user_id: Int
)