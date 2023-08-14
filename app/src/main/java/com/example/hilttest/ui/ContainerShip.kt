package com.example.hilttest.ui

import android.util.Log
import javax.inject.Inject

class ContainerShip @Inject constructor() : Ship {
    override fun start() {
        Log.d("daeYoung", "컨테이너 쉽 시작")
    }
}