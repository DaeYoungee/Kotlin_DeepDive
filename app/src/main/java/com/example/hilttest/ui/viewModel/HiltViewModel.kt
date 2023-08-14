package com.example.hilttest.ui.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hilttest.ui.network.HiltRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HiltViewModel @Inject constructor(private val repository: HiltRepository): ViewModel() {

    private val _id = mutableStateOf("")
    val id: State<String> = _id

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    // Switch 컴포저블 상태 값
    private val _autoLoginState = mutableStateOf(false)
    val autoLoginState: State<Boolean> = _autoLoginState

    // Switch 컴포저블 상태 변경 함수
    fun setAutoLoginState() {
        _autoLoginState.value = !_autoLoginState.value
    }

    fun setId(id: String) {
        _id.value = id
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun getUserPref(): String? =
        repository.getUserPref()

    fun setUserPrefs(value: String) {
        repository.setUserPrefs(value = value)
    }

    fun getAutoLoginPref(): Boolean =
        repository.getAutoLoginPref()

    fun setAutoLoginPref() {
        repository.setAutoLoginPref(value = autoLoginState.value)
    }

    fun logout() {
        repository.logout()
    }
}

