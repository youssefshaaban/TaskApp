package com.example.taskapp.ui.Screens.HomeScreen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.taskapp.R
import com.example.taskapp.domain.model.Medicine

@Composable
private fun IteMMedicineCard(modifier: Modifier = Modifier, medicine: Medicine) {
    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(20.dp),
        modifier = modifier.padding(10.dp)
    ) {

        Column (modifier=Modifier.padding(20.dp)){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "${stringResource(id = R.string.medecine_name)} :")
                Text(text = medicine.name)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "${stringResource(id = R.string.dose_name)} :")
                Text(text = medicine.dose)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "${stringResource(id = R.string.strength)} :")
                Text(text = medicine.strength)
            }
        }

    }
}

@Composable
fun MedicineList(modifier: Modifier = Modifier, list: List<Medicine>) {
    LazyColumn(modifier = modifier) {
        items(list){medecine->
            IteMMedicineCard(modifier=Modifier.fillMaxWidth(),medicine = medecine)
        }
    }
}