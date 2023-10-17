package com.example.simpleapp.ui.Screens.HomeScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskapp.domain.interactors.GetMedicineUseCase
import com.example.taskapp.domain.model.Medicine
import com.example.taskapp.domain.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMedicineUseCase: GetMedicineUseCase) :
    ViewModel() {

    private val _medicineState = mutableStateOf<Resource<List<Medicine>>>(Resource.Loading)
    val medicineState: MutableState<Resource<List<Medicine>>> = _medicineState

    init {

        viewModelScope.launch {
            _medicineState.value = getMedicineUseCase.invoke()
        }

    }
}