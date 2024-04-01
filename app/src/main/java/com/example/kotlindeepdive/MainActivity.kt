package com.example.kotlindeepdive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlindeepdive.list.MutableStateOfListEx
import com.example.kotlindeepdive.sideeffect.DerivedStateOfEx
import com.example.kotlindeepdive.sideeffect.MainViewModel
import com.example.kotlindeepdive.ui.theme.KotlinDeepDiveTheme
import com.example.kotlindeepdive.R
import com.example.kotlindeepdive.paging.MovieViewModel
import com.example.kotlindeepdive.paging.ui.MovieScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MovieViewModel>()
            KotlinDeepDiveTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                    derive
//                }
                MovieScreen(movieViewModel = viewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Test() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Divider(
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 2.dp),
            color = Color.Black
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()

        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(IntrinsicSize.Min),
            ) {
                Divider(
                    color = Color.Yellow,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(4.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "안녕")
                Box() {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
        Divider(
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp),
            color = Color.Black
        )
    }
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//    ) {
//        Divider(
//            thickness = 1.dp,
//            modifier = Modifier.fillMaxWidth().padding(bottom = 2.dp),
//            color = Color.Black
//        )
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(IntrinsicSize.Min),
//        ) {
//            Divider(
//                color = Color.Yellow,
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(4.dp)
//            )
//            Spacer(modifier = Modifier.width(20.dp))
//            Row(modifier = Modifier.fillMaxWidth(0.5f)) {
//                Text(
//                    text = "순위",
//                    color = Color.Black,
//                    fontSize = 12.sp,
//                    modifier = Modifier.fillMaxWidth(0.3f)
//                )
//                Text(
//                    text = "이름",
//                    color = Color.Black,
//                    fontSize = 12.sp,
//                    modifier = Modifier.weight(1f)
//                )
//            }
//            Row(modifier = Modifier.weight(1f)) {
//                Text(
//                    text = "점수",
//                    color = Color.Black,
//                    fontSize = 12.sp,
//                    modifier = Modifier.fillMaxWidth(0.5f)
//                )
//                Text(
//                    text = "기여도",
//                    color = Color.Black,
//                    fontSize = 12.sp,
//                    modifier = Modifier.fillMaxWidth()
//                )
//            }
//        }
//        Divider(
//            thickness = 1.dp,
//            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
//            color = Color.Black
//        )
//    }
}