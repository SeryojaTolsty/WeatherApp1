package ru.gb.kotlinapp.model

interface Repo {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorage(): Weather
}