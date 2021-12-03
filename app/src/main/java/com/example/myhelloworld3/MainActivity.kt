package com.example.myhelloworld3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

import kotlin.random.Random.Default.nextInt

const val TAG = "MainActivity"
const val KEY = "random text"

class MainActivity : AppCompatActivity() {

    lateinit var randomTextView: TextView
    lateinit var randomButton: Button

    fun randomize() {
        randomTextView.text = Random.nextInt(100).toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Я помню чудное мгновенье")

        randomTextView = findViewById(R.id.random_text_view)
        randomButton = findViewById(R.id.random_button)

        if(savedInstanceState != null)
            randomTextView.text=savedInstanceState.getString(KEY)

        randomButton.setOnClickListener {
            randomize()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(KEY, randomTextView.text.toString())
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Передо мной явилась ты")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Как мимолетное виденье")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Как гений чистой красоты")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "В томленьях грусти безнадежной")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "В тревогах шумной суеты")
    }
}
