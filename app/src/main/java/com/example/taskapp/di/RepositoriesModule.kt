package com.example.taskapp.di


import com.example.taskapp.data.remote.ApiService
import com.example.taskapp.data.repositeries.MedicineRepoImp
import com.example.taskapp.domain.repositeries.MedicineRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Singleton
    @Provides
    fun provideMedicineRepo(apiService: ApiService): MedicineRepo = MedicineRepoImp(apiService)
}