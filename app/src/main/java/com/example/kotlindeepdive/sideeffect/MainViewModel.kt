package com.example.kotlindeepdive.sideeffect

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class MainViewModel():ViewModel() {
    private val _count = mutableIntStateOf(0)
    val count: State<Int> = _count

    var number = 0

    private val _derivedCount = derivedStateOf {
        number = count.value
        Log.d("daeyoung", "derivedCount 실행, number: $number")
        count.value + number * 2
        }
    val derivedCount: State<Int> = _derivedCount

    fun plus() {
        _count.value++
    }

}