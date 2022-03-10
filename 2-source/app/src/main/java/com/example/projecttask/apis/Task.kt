package com.example.projecttask.apis

data class Task(
    val category_id: Int,
    val created_at: String,
    val created_user_id: Int,
    val deleted_at: Any,
    val sequence: Any,
    val status: Int,
    val task_cache_comments: Any,
    val task_cache_other_posts: Any,
    val task_cache_time: Any,
    val task_description: String,
    val task_files: String,
    val task_id: Int,
    val task_image: String,
    val task_name: String,
    val task_start_date: String,
    val task_end_date: String,
    val task_order: Any,
    val task_overview: String,
    val task_slug: String,
    val updated_at: String,
    val updated_user_id: Int
)