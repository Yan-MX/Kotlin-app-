package com.example.yanji_oblig1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickHandler()


    }
    private fun clickHandler() {
        val palindromButton = findViewById<Button>(R.id.palindromButton);
        val userInput = findViewById<TextView>(R.id.userInput);
        val answer = findViewById<TextView>(R.id.answer)

        palindromButton.setOnClickListener {
            val input = userInput.text.toString()
            val isPal = isPalindrome(input)
            if (isPal) answer.setText("Your name is a palindrome") else answer.setText("Your name is NOT a palindrome")

        }
    }
    private  fun isPalindrome(input:String): Boolean{
        var indexStart = 0
        var indexEnd = input.length - 1
        while (indexStart < indexEnd) {
            if (input.get(indexStart).toLowerCase() != input.get(indexEnd).toLowerCase())
                return false;
            indexStart++;
            indexEnd--;
        }
        return true;
    }
}