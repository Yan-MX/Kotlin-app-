package com.example.yanji_oblig1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.yanji_oblig1.Question as Question


class QuizActivity : AppCompatActivity() {
    val questions= mutableListOf<Question>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        questions.add(Question("Kotlin is developed by JetBrains", true))
        questions.add(Question("Kotlin has 100% Interoperability With Java and Javascript", false))
        questions.add(Question("Kotlin distinguishes between mutable and immutable collections", true))
        startGame( questions)

    }
    public fun back( button : android.view.View){
        val score = findViewById<TextView>(R.id.score)
        score.setText("")
        startGame( this.questions)
    }
    public fun startGame(questions: MutableList<Question> ){
        val question = findViewById<TextView>(R.id.ques)
        val score = findViewById<TextView>(R.id.score)
        val answerTrue = findViewById<Button>(R.id.buttonTrue)
        val answerFalse = findViewById<Button>(R.id.buttonFalse)
        answerTrue.background.setAlpha(255)
        answerFalse.background.setAlpha(255)
        var index = 0
        var point = 0
        question.setText(questions[index].question)
        answerTrue.setOnClickListener(){
                if (index < questions.size){
                    if (questions[index].answer==true ){
                        point ++
                    }
                index ++
                score.setText("Your score: $point / $index")
                  if(index < questions.size){
                      question.setText(questions[index].question)
                  } else {
                      question.setText("")
                      answerTrue.background.setAlpha(64)
                      answerFalse.background.setAlpha(64)

                  }
                }
            }
        answerFalse.setOnClickListener(){
                if (index < questions.size) {
                    if (questions[index].answer == false) {
                        point++
                    }
                index++
                    score.setText("Your score: $point / $index")
                    if(index < questions.size){
                        question.setText(questions[index].question)
                    } else {
                        question.setText("")
                        answerTrue.background.setAlpha(25)
                        answerFalse.background.setAlpha(25)

                    }
                }
            }



    }
}

