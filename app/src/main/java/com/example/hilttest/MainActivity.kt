package com.example.hilttest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hilttest.ui.viewModel.HiltViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: HiltViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val state = intent.getBooleanExtra("currentLoginState", false)
        if (!state) {
            if (!viewModel.getAutoLoginPref()) {
                moveLoginActivity()
                finish()
            }
        }


        setContent {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "메인 화면", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Button(onClick = {
                    viewModel.logout()
                    moveLoginActivity()
                }) {
                    Text(text = "로그아웃")
                }
            }
        }
    }

    fun moveLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

}

