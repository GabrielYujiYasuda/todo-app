package com.example.myapplication.common.helper.date

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateHelper {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault())

    @ToJson fun toJson(date: Date): String {
        return dateFormat.format(date)
    }

    @FromJson fun fromJson(json: String): Date {
        return dateFormat.parse(json) ?: Date()
    }
}