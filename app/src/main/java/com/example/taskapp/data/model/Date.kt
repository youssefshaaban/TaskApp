package com.example.taskapp.data.model

import com.example.taskapp.domain.model.Medicine


data class Date(
    val dose: String,
    val name: String,
    val strength: String
)

fun Date.toMedicine(): Medicine {
    return Medicine(this.dose,this.name,this.strength)
}