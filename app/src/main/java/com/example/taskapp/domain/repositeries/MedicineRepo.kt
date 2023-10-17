package com.example.taskapp.domain.repositeries

import com.example.taskapp.domain.model.Medicine
import com.example.taskapp.domain.model.Resource


interface MedicineRepo {
   suspend fun getMedicines(): Resource<List<Medicine>>
}