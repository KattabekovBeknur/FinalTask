package com.example.moviedb.domain.repository

import androidx.lifecycle.LiveData
import com.example.moviedb.data.room.Cinema

interface CinemaRepository {

    fun getAllCinemas(): LiveData<List<Cinema>>

    fun getCinema(id: Int): LiveData<Cinema>
}