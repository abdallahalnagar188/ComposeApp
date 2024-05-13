package com.example.composeapp

data class Gym(val id: Int, val name: String, val details: String, var isFavorite: Boolean = false)

val gym = listOf(
    Gym(1,"Hammer Gym", "cairo eg, mit akaba ,20 algihad street "),
    Gym(2,"UpDown Gym", "cairo eg, mit akaba ,20 algihad street "),
    Gym(3,"Halk Gym", "cairo eg, mit akaba ,20 algihad street "),
    Gym(4,"H2o Gym", "cairo eg, mit akaba ,20 algihad street "),
    Gym(5,"H2o Gym", "cairo eg, mit akaba ,20 algihad street "),
    Gym(6,"Hammer Gym", "cairo eg, mit akaba ,20 algihad street "),
)
