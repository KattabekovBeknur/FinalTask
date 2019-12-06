package com.example.moviedb.domain.repository

import com.example.moviedb.data.models.MovieData
import com.example.moviedb.data.models.MovieResponseData

interface MovieRepository {

    suspend fun getPopularMovies(page: Int) : MovieResponseData?

    suspend fun getMovieById(movieId: Int): MovieData?

    suspend fun getFavoriteMovies(accountId: Int, sessionId: String, page: Int): MovieResponseData?

    suspend fun rateMovie(movieId: Int, accountId: Int, sessionId: String, favorite: Boolean): Int?

    suspend fun getState(movieId: Int, accountId: Int, sessionId: String, favoriteState: Boolean): Int?

}