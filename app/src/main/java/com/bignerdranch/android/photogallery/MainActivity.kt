package com.bignerdranch.android.photogallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import coil.load


private const val TAG = "MOVIE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieRepository = MovieRepository()

        val edit = findViewById<EditText>(R.id.edit)

        var title = findViewById<TextView>(R.id.textView1)
        var year = findViewById<TextView>(R.id.textView2)
        var poster = findViewById<ImageView>(R.id.imageView)

        val button = findViewById<Button>(R.id.button)


        button.setOnClickListener() {

            lifecycleScope.launch {
                try {
                    delay(1500)
                    val items = movieRepository.fetchMovies(edit.text.toString(), "json")

                    Log.d(TAG, "Items received: $items")
                    title.text = items[0].title
                    year.text = items[0].year
                    poster.load(items[0].poster)

                } catch (ex: Exception) {
                    Log.e(TAG, "Failed to fetch movies", ex)
                    Toast.makeText(applicationContext, "No movies found", Toast.LENGTH_SHORT).show()
                }
            }
        }





    }
}