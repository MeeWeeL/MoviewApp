package com.meeweel.movieapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meeweel.movieapp.data.network.Retrofit
import com.meeweel.movieapp.data.repository.RemoteRepositoryImpl
import com.meeweel.movieapp.data.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(private val repo: Repository = RemoteRepositoryImpl(Retrofit().getService())) : ViewModel() {

    private val liveDataToObserve: MutableLiveData<MainAppState> = MutableLiveData()
    fun getData(): LiveData<MainAppState> {
        return liveDataToObserve
    }

    fun requestFilms() = requestFilmsFromApi()

    private fun requestFilmsFromApi() {
        repo.getFilms()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                liveDataToObserve.postValue(MainAppState.Loading)
            }
            .subscribe({
                liveDataToObserve.postValue(MainAppState.Success(it))
            },{
                liveDataToObserve.postValue(MainAppState.Error(Throwable("RxJava Error")))
            })
    }
}