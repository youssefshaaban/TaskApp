package com.example.taskapp.data.repositeries



import com.example.taskapp.data.model.toMedicine
import com.example.taskapp.data.remote.ApiService
import com.example.taskapp.data.util.apiCall
import com.example.taskapp.domain.model.Medicine
import com.example.taskapp.domain.model.Resource
import com.example.taskapp.domain.repositeries.MedicineRepo
import javax.inject.Inject

class MedicineRepoImp @Inject constructor(private val apiService: ApiService) : MedicineRepo {
    override suspend fun getMedicines(): Resource<List<Medicine>> {
        val result = apiCall {
            apiService.getMedicines()
        }
        return when (result) {
            is Resource.Success -> {
                Resource.Success(result.data.date.map { it.toMedicine() })
            }

            is Resource.Error -> {
                Resource.Error(result.error)
            }

            is Resource.Loading -> {
                Resource.Loading
            }
        }


    }

}