package com.example.hilttest.ui

import android.util.Log
import javax.inject.Inject

class BattleShip @Inject constructor(): Ship {
    override fun start() {
        Log.d("daeYoung", "배틀 쉽 시작")
    }
}