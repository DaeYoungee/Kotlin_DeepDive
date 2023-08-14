package com.example.hilttest.ui.network

import android.content.SharedPreferences
import javax.inject.Inject


class HiltRepository @Inject constructor(private val sharedPreferences: SharedPreferences) {

    // 사용자 토큰을 불러옴
    fun getUserPref(
        userToken: String = "userToken",
        defaultValue: String = "",
    ): String? =
        sharedPreferences.getString(userToken, defaultValue)

    // 사용자 토큰을 저장
    fun setUserPrefs(value: String) {
        sharedPreferences.edit().putString("userToken", value).apply()
    }

    // 자동 로그인 boolean 값 불러옴
    fun getAutoLoginPref(
        autoLoginState: String = "autoLoginState",
    ): Boolean =
        sharedPreferences.getBoolean(autoLoginState, false)

    // 자동 로그인 설정
    fun setAutoLoginPref(value: Boolean) {
        sharedPreferences.edit().putBoolean("autoLoginState", value).apply()
    }

    fun logout() {
        sharedPreferences.edit().clear().apply()
    }
}
