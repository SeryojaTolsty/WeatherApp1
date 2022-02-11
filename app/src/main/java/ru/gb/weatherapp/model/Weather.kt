package ru.gb.kotlinapp.model

data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int = 0,
    val feelsLike: Int = 0
)
fun getDefaultCity() = City("Москва", 55.75826, 37.6172999000035)
