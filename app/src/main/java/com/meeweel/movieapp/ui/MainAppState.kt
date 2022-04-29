package com.meeweel.movieapp.ui

import com.meeweel.movieapp.domain.Film

sealed class MainAppState {
    data class Success(val dataList: List<Film>) : MainAppState()
    class Error(val error: Throwable) : MainAppState()
    object Loading : MainAppState()
}