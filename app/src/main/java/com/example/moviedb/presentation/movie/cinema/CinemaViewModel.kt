package com.example.moviedb.presentation.movie.cinema

import androidx.lifecycle.LiveData
import com.example.moviedb.base.BaseViewModel
import com.example.moviedb.data.repository.CinemaRepositoryImpl
import com.example.moviedb.data.room.Cinema
import com.example.moviedb.data.room.CinemaDao
import com.example.moviedb.domain.repository.CinemaRepository
import com.example.moviedb.exceptions.NoConnectionException

class CinemaViewModel(private val cinemaDao: CinemaDao): BaseViewModel() {

    private val repository: CinemaRepository

    var liveData: LiveData<List<Cinema>>

    init {
        repository = CinemaRepositoryImpl(cinemaDao)
        liveData = repository.getAllCinemas()
    }
    override fun handleError(e: Throwable) {
        if (e is NoConnectionException) {
            //ToDo
        }
    }
}