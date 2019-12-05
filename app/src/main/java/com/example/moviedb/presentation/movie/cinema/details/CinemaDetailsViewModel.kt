package com.example.moviedb.presentation.movie.cinema.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.moviedb.data.repository.CinemaRepositoryImpl
import com.example.moviedb.data.room.Cinema
import com.example.moviedb.data.room.CinemaRoomDatabase
import com.example.moviedb.domain.repository.CinemaRepository
import kotlinx.coroutines.launch

class CinemaDetailsViewModel(application: Application): AndroidViewModel(application) {

    private val repository: CinemaRepository

    lateinit var liveData: LiveData<Cinema>

    init {
        val cinemaDao = CinemaRoomDatabase.getDatabase(application, viewModelScope).cinemaDao()
        repository = CinemaRepositoryImpl(cinemaDao)
    }

    fun getCinema(id: Int) {
        viewModelScope.launch {
            val cinema = repository.getCinema(id)
            cinema.let { cinema->
                liveData = cinema
            }
        }
    }
}