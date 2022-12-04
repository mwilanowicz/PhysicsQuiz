package com.example.physicsquiz
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

// Tutaj mamy przycisk start, ktory wywoluje wlasciwy quiz

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun start(view: View){
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }
}