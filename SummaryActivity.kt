package com.example.physicsquiz
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SummaryActivity : AppCompatActivity() {
    val pointsText: TextView by lazy{findViewById(R.id.Points)}
    val cheatCountText: TextView by lazy { findViewById(R.id.CheatCount) }
    val correctCountText: TextView by lazy { findViewById(R.id.CorrectCount) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        val bundle = intent.extras!!
        val points = bundle.getInt("points")
        val cheatCount = bundle.getInt("cheatCount")
        val correctCount = bundle.getInt("correctCount")

        pointsText.text = "Points: $points"
        cheatCountText.text = "Cheated: $cheatCount"
        correctCountText.text = "Correct answers: $correctCount"
    }
    fun restart(view: View?){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
