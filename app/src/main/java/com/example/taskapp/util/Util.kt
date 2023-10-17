package com.example.taskapp.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Calendar

fun greetUserByTimeOfDay(userName: String): String {
    val currentTime = Calendar.getInstance()
    val hour = currentTime.get(Calendar.HOUR_OF_DAY)

    return when {
        hour in 6..11 -> "Good morning, $userName!"
        hour in 12..17 -> "Good afternoon, $userName!"
        hour in 18..21 -> "Good evening, $userName!"
        else -> "Good night, $userName!"
    }
}