package com.example.kotlindeepdive.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlindeepdive.paging.data.Constants
import com.example.kotlindeepdive.paging.data.Movie
import com.example.kotlindeepdive.paging.data.mapFromListModel
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MoviePagingSource @Inject constructor(
    private val movieApi: MovieApi
): PagingSource<Int, Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPage = params.key ?: 1
            val movies = movieApi.getMovies(
                apiKey = Constants.MOVIE_API_KEY,
                pageNumber = currentPage
            )
            LoadResult.Page(
                data = movies.results!!.mapFromListModel(),
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (movies.results.isEmpty()) null else movies.page!! + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}