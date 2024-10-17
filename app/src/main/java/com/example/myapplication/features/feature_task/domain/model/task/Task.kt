package com.example.myapplication.features.feature_task.domain.model.task

import com.squareup.moshi.Json
import java.util.Date

data class Task(
    @field:Json(name = "id") var id: Int,
    @field:Json(name = "name") var name: String,
    @field:Json(name = "date") var date: Date,
)