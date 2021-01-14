package com.example.yanji_oblig1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickHandler()


    }
    private fun clickHandler() {
        val palindromButton = findViewById<Button>(R.id.palindromButton)
        val userInput = findViewById<TextView>(R.id.userInput)
        val answer = findViewById<TextView>(R.id.answer)
        val nextPage = findViewById<Button>(R.id.nextPageButton)

        palindromButton.setOnClickListener {
            val input = userInput.text.toString()
            val isPal = isPalindrome(input)
            if (input.trim().length>0) if (isPal ) answer.setText(getString(R.string.answerYes)) else answer.setText(getString(
                            R.string.answerNo))


        }
        nextPage.setOnClickListener {
            var intent = Intent(this, ConverterActivity::class.java)
            startActivity (intent)
            userInput.setText("")
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