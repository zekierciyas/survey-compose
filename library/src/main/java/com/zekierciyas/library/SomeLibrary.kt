package com.zekierciyas.library

import java.util.Random

object SomeLibrary {

    fun getResult(): String{
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..50)
            .map { allowedChars.random() }
            .joinToString("")
    }
}