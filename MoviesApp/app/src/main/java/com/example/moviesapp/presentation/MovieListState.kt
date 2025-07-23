package com.example.moviesapp.presentation


import com.example.moviesapp.domain.model.Movie

/**
 * @author Android Devs Academy (Ahmed Guedmioui)
 */
data class MovieListState(
    val isLoading: Boolean = false,

    val popularMovieListPage: Int = 1,
    val upcomingMovieListPage: Int = 1,
    val searchPage: Int = 1,

    val isCurrentPopularScreen: Boolean = true,

    val searchQuery: String = "",

    val popularMovieList: List<Movie> = emptyList(),
    val upcomingMovieList: List<Movie> = emptyList(),
    val searchList: List<Movie> = emptyList()
)