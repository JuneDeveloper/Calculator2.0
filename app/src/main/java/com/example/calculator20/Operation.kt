package com.example.calculator20

class Operation(private val first:String,private val second:String) {
    fun sum() = Integer.parseInt(first) + Integer.parseInt(second)
    fun dif() = Integer.parseInt(first) - Integer.parseInt(second)
    fun mult() = Integer.parseInt(first) * Integer.parseInt(second)
    fun div() = Integer.parseInt(first).toDouble() / Integer.parseInt(second).toDouble()
}