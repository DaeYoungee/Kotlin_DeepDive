package com.example.kotlindeepdive.paging.ui

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.kotlindeepdive.paging.MovieViewModel
import com.example.kotlindeepdive.paging.data.Movie

@Composable
fun MovieScreen(movieViewModel: MovieViewModel = hiltViewModel()) {
    val moviePagingItems: LazyPagingItems<Movie> =
        movieViewModel.movieState.collectAsLazyPagingItems()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item { Spacer(modifier = Modifier.padding(4.dp)) }

        items(moviePagingItems.itemCount) { index ->
            ItemMovie(
                itemEntity = moviePagingItems[index]!!,
                onClick = {}
            )
        }
        moviePagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    Log.d("daeYoung", "loadState.refresh is Loading")
                }

                loadState.refresh is LoadState.Error -> {
                    Log.d("daeYoung", "loadState.refresh is Error")
                }

                loadState.append is LoadState.Loading -> {
                    Log.d("daeYoung", "loadState.append is Loading")
                }

                loadState.append is LoadState.Error -> {
                    Log.d("daeYoung", "loadState.append is Error")
                }
            }
        }
        item { Spacer(modifier = Modifier.padding(4.dp)) }
    }
}