package com.example.kotlindeepdive

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val mutableSharedFlow = MutableSharedFlow<String>()

    launch {
        repeat(3) {
            mutableSharedFlow.emit("Message$it")
            delay(1000)
        }
    }

    delay(2000)

    launch {
        mutableSharedFlow.collect {
            println("#1 received $it")
        }
    }
}