package com.example.physicsquiz
import android.content.Intent
import android.content.Intent.CATEGORY_BROWSABLE
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView

class QuizActivity : AppCompatActivity() {
    private val questionText: TextView by lazy { findViewById(R.id.Question) }
    private val questionList = Questions.getQuestions()
    private var  questionPosition = 1  // Zmienna reprezentujaca numer pytania

    private val progressBar: ProgressBar by lazy { findViewById(R.id.progress_bar)}
    private val progressText: TextView by lazy { findViewById(R.id.text_view_progress)}

    private var points = 0
    private var correctCount = 0
    private var cheatCount = 0

    private fun setQuestion(){  // Funkcja ustawiajaca odpowiednie pytanie
        val question = questionList[questionPosition - 1]
        progressBar.progress = questionPosition
        "$questionPosition / ${progressBar.max}".also { progressText.text = it }
        questionText.text = question.question
    }
    fun True(view: View){  // Obsluga przycisku "True"
        if (questionList[questionPosition - 1].answer == true) {
            points += 10
            correctCount++
        }
        questionPosition++
        if (questionPosition > questionList.size){
            val intent = Intent(this, SummaryActivity::class.java)
            val bundle = Bundle()
            bundle.putInt("points", points)
            bundle.putInt("correctCount", correctCount)
            bundle.putInt("cheatCount", cheatCount)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        else
            setQuestion()
    }
    fun False(view: View){  // Obsluga przycisku "False"
        if (questionList[questionPosition - 1].answer == false) {
            points += 10
            correctCount++
        }
        questionPosition++
        if (questionPosition > questionList.size){
            val intent = Intent(this, SummaryActivity::class.java)
            val bundle = Bundle()
            bundle.putInt("points", points)
            bundle.putInt("correctCount", correctCount)
            bundle.putInt("cheatCount", cheatCount)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        else
            setQuestion()
    }
    fun Cheat(view: View){  // Obsluga przycisku "Cheat"
        points -= 15
        cheatCount++
        val intent = Intent(this, CheatActivity::class.java)
        val bundle = Bundle()
        bundle.putInt("points", points)
        bundle.putInt("correctCount", correctCount)
        bundle.putInt("cheatCount", cheatCount)
        bundle.putInt("questionPosition", questionPosition)
        bundle.putBoolean("answer", questionList[questionPosition - 1].answer)
        intent.putExtras(bundle)
        startActivity(intent)
    }
    fun Search(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        intent.addCategory(CATEGORY_BROWSABLE)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {  // Konstruktor
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        setQuestion()
    }
}

