package com.example.yanji_oblig1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ConverterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)
        convertHandler()
    }

    public fun  next(button: android.view.View){
        var intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
        val userInput2 = findViewById<TextView>(R.id.userInput2)
        val answer2 = findViewById<TextView>(R.id.answer2)
        userInput2.setText("")
        answer2.setText("")
    }
    public fun convertHandler(){
        val convertButton = findViewById<Button>(R.id.convertButton)
        val userInput2 = findViewById<TextView>(R.id.userInput2)
        val answer2 = findViewById<TextView>(R.id.answer2)
        val spinner = findViewById<Spinner>(R.id.spinner)
        var spinnerOption= arrayOf<String>(getString(R.string.fo),
            getString(R.string.cup),
            getString(
                R.string.gal),
            getString(R.string.hog))
        var optionSelected = getString(R.string.fo)
        spinner.adapter= ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,
            spinnerOption)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
               optionSelected= spinnerOption.get(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        convertButton.setOnClickListener {
            val inputManager: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            inputManager.hideSoftInputFromWindow(currentFocus!!.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS)
            if (userInput2.text.toString().trim().isEmpty()) {
                answer2.setText(getString(R.string.alertmessage))}
            else {
                val num = userInput2.text.toString().toFloat()
                var result = when (optionSelected) {
                    getString(R.string.fo) -> num * 0.02957
                    getString(R.string.cup) -> num * 0.23659
                    getString(R.string.gal) -> num * 3.78541
                    getString(R.string.hog) -> num * 238.481
                    else -> 0.00
                }
                answer2.setText(result.toString())
            }
        }


    }
}