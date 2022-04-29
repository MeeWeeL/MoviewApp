package com.meeweel.movieapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meeweel.movieapp.data.FakeRepo

class MainViewModel(private val repo: FakeRepo = FakeRepo()) : ViewModel() {

    private val liveDataToObserve: MutableLiveData<MainAppState> = MutableLiveData()
    fun getData(): LiveData<MainAppState> {
        return liveDataToObserve
    }

    fun requestFilms() = requestFilmsFromApi()

    private fun requestFilmsFromApi() {
        liveDataToObserve.postValue(MainAppState.Success(repo.getList()))
    }
}