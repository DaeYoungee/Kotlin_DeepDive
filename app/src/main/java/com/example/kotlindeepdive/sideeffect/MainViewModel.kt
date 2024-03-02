package com.example.kotlindeepdive.sideeffect

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

class MainViewModel():ViewModel() {
    private val _count = mutableIntStateOf(0)
    val count: State<Int> = _count

    private val _derivedCount = derivedStateOf {
            Log.d("daeyoung", "derivedCount 실행")
            count.value * 2
        }
    val derivedCount: State<Int> = _derivedCount

    fun plus() {
        _count.value++
    }

}