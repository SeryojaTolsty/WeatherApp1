package ru.gb.weatherapp.model

class RepoImpl : Repo {
    override fun getWeatherFromServer(): Weather {
        return Weather()
    }

    override fun getWeatherFromLocalStorageRus(): List<Weather> {
        return getRussianCities()
    }

    override fun getWeatherFromLocalStorageWorld(): List<Weather> {
        return getWorldCities()
    }

}