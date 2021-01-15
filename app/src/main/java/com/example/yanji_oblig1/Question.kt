package com.example.yanji_oblig1

class Question (val question: String, val answer: Boolean){

    fun checkAnswer(userAnswer: Boolean) :Boolean{
        if(userAnswer==answer) return true else return false
    }

}