package ru.gb.weatherapp.ui


import android.util.Log
import junit.framework.Test
import ru.gb.weatherapp.model.Weather

class LearnTest {
    var nonNullable: String = ""
    var name = "Иван"
    var fullName: String? = ""


    private val TAG = "${Test::class.java.simpleName}"

    fun checkString(s: String): String? {
        return null
    }

    fun test() {
        var nullable: String? = ""

        if (nullable != null) {
            val length = nullable.length
            nonNullable = nullable
        }

        val name: String? = "John"
        val nameLength: Int = name?.length ?: 1
        val length = nullable!!.length

        val integer: Int? = 1
    }

    fun test2() {
        val phrase: Array<String> = arrayOf("I", "love", "kotlin")
        val lang = phrase[2]
        phrase[1] = "know"
        val wordCount = phrase.size

        val people: List<Person> = mutableListOf(Person("Василий", 25), Person("Татьяна", 23))
        people[0].age = 30

        val list: List<String> = ArrayList()
        val mutableSet: MutableSet<Int> = HashSet()

        val people1 = people.filter { it.age < 30 }.map { it }.find { it.age > 20 }
        val people2 = people.count { it.age > 23 }

        val people3 = people.any { it.age > 23 }
        val people4 = people.all { it.age < 23 }
    }

    fun saveWeather(weather : Weather){
        Log.d("TAG", "saveWeather: $weather is good")
    }

    class Person(val name: String, var age: Int)



    //Lesson 4
    val greetingsFun = {"Hello"}

    fun sum1(a: Int, b: Int) : Int{
        return a + b
    }
    val sum = {a: Int, b: Int -> a + b}
}