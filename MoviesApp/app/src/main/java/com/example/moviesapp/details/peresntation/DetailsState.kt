package com.example.moviesapp.details.peresntation


import com.example.moviesapp.domain.model.Movie


data class DetailsState(
    val isLoading: Boolean = false,
    val movie: Movie? = null
)