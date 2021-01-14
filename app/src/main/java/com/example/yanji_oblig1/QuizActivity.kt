package com.example.yanji_oblig1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
    }
    public fun  back( button : android.view.View){
        var intent = Intent(this, MainActivity::class.java)
        startActivity (intent)
    }
}