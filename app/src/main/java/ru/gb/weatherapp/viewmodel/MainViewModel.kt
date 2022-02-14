package ru.gb.kotlinapp.viewmodel


import java.lang.Thread.sleep
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.gb.kotlinapp.model.Repo
import ru.gb.kotlinapp.model.RepoImpl

class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repoImpl: Repo = RepoImpl()
) : ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getWeatherFromRemoteSource() = getDataFromLocalSource(isRussian = true)

    fun getWeatherFromLocalSourceRus() = getDataFromLocalSource(isRussian = true)
    fun getWeatherFromLocalSourceWorld() = getDataFromLocalSource(isRussian = false)

    private fun getDataFromLocalSource(isRussian: Boolean) {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(2000)
            liveDataToObserve.postValue(
                AppState.Success(
                    if (isRussian)
                        repoImpl.getWeatherFromLocalStorageRus()
                    else
                        repoImpl.getWeatherFromLocalStorageWorld()
                )
            )
        }.start()
    }
}