package com.example.hilttest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hilttest.ui.viewModel.HiltViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    private val viewModel: HiltViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                TextField(
                    value = viewModel.id.value,
                    onValueChange = { viewModel.setId(it) },
                    placeholder = { Text(text = "ID") })
                TextField(
                    value = viewModel.password.value,
                    onValueChange = { viewModel.setPassword(it) },
                    placeholder = { Text(text = "PW") })
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Button(modifier = Modifier.padding(end = 16.dp), onClick = {
                        viewModel.setUserPrefs("1234")
                        viewModel.setAutoLoginPref()
                        moveMainActivity(viewModel.autoLoginState.value)
                    }) {
                        Text(text = "로그인")
                    }
                    Switch(
                        checked = viewModel.autoLoginState.value,
                        onCheckedChange = {
                            viewModel.setAutoLoginState()
                        }
                    )
                }
            }
        }
    }

    private fun moveMainActivity(autoLoginState: Boolean) {
        finish()
        val intent = Intent(this, MainActivity::class.java).also {
            it.putExtra("currentLoginState", true)
        }
        startActivity(intent)
    }

}