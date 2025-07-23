package com.example.moviesapp.presentation


sealed interface MovieListUiEvent {
    data class Paginate(val category: String) : MovieListUiEvent
    object Navigate : MovieListUiEvent
    data class Search(val query: String) : MovieListUiEvent
}