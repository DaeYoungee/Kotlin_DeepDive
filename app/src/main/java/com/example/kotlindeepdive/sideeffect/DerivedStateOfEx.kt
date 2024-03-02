package com.example.kotlindeepdive.sideeffect

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DerivedStateOfEx(mainViewModel: MainViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Log.d("daeyoung", "count: ${mainViewModel.count}")
        Log.d("daeyoung", "일반로그")


        Button(onClick = {
            mainViewModel.plus()

        }) {
            Text(text = "plus")
        }
        Text(text = mainViewModel.count.value.toString(), modifier = Modifier.padding(vertical = 16.dp))
        Log.d("daeyoung", "일반로그2")
        Text(text = mainViewModel.derivedCount.value.toString(), modifier = Modifier.padding(vertical = 16.dp))
    }
}