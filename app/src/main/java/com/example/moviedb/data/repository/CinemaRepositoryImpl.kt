package com.example.moviedb.data.repository

import androidx.lifecycle.LiveData
import com.example.moviedb.data.room.Cinema
import com.example.moviedb.data.room.CinemaDao
import com.example.moviedb.domain.repository.CinemaRepository

class CinemaRepositoryImpl(private val cinemaDao: CinemaDao) : CinemaRepository {

    override fun getAllCinemas(): LiveData<List<Cinema>> = cinemaDao.getCinemas()

    override fun getCinema(id: Int): LiveData<Cinema> = cinemaDao.getCinema(id)
}