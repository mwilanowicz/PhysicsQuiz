package com.example.physicsquiz
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CheatActivity : AppCompatActivity() {
    private val answerText: TextView by lazy { findViewById(R.id.CheatAnswer) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        val bundle = intent.extras!!
        val questionNumber = bundle.getInt("questionPosition")
        val answer = bundle.getBoolean("answer")

        answerText.text = "Answer to question $questionNumber is: $answer"
    }
    fun close(view: View?){
        val bundle = intent.extras!!
        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtras(bundle)
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
    }
}