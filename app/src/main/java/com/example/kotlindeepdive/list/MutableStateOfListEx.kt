package com.example.kotlindeepdive.list

import android.nfc.Tag
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MutableStateOfListEx() {
    val list = remember {
        mutableStateListOf<String>()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.wrapContentSize()) {
            list.forEach {
                Text(text = it)
            }
        }
        Button(onClick = {
            list.add("d")
            list.forEach {
                Log.d("daeyoung", "list: $it")
            }
        }) {
            Text(text = "추가")
        }
    }
}