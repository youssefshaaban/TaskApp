package com.example.taskapp.domain.interactors

import com.example.taskapp.domain.model.Medicine
import com.example.taskapp.domain.model.Resource
import com.example.taskapp.domain.repositeries.MedicineRepo
import javax.inject.Inject

class GetMedicineUseCase @Inject constructor(private val medicineRepo: MedicineRepo) {
    suspend operator fun invoke(): Resource<List<Medicine>> =
        medicineRepo.getMedicines()
}