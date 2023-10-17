package com.example.taskapp.ui.Screens.HomeScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.simpleapp.ui.Screens.HomeScreen.HomeViewModel
import com.example.taskapp.domain.model.Resource
import com.example.taskapp.util.greetUserByTimeOfDay

@Composable
fun HomeScreen(userName: String) {
    val homeViewModel: HomeViewModel = hiltViewModel()

    val statList = homeViewModel.medicineState.value

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Text(modifier = Modifier.padding(10.dp),text = greetUserByTimeOfDay(userName))
            when(statList){
                is Resource.Loading->{
                    Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator()
                    }
                }
                is Resource.Success->{
                    MedicineList(modifier = Modifier.fillMaxSize(),list = statList.data)
                }
                is Resource.Error->{
                    Log.e("ERRORO","EROROR")
                }
            }
        }
}