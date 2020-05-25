package com.example.newssecond

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class MovieDetail : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Detail","OnCreate: Successful")
        setContentView(R.layout.movie_item)
        val poster_text: String? = intent.getStringExtra("poster")
        val title_text: String? = intent.getStringExtra("title")
        val overview_text: String? = intent.getStringExtra("overview")
        val ratingtext: String? = intent.getStringExtra("rating")

        supportActionBar?.setTitle(title_text)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val photo: ImageView = findViewById(R.id.movie_photo)
        val title: TextView = findViewById(R.id.movie_title)
        val overview: TextView = findViewById(R.id.movie_overview)
        val rating: TextView = findViewById(R.id.movie_rating)

        overview.visibility = View.VISIBLE

        Glide.with(this).load(poster_text).into(photo)
        title.text = "Title: $title_text"
        overview.text = "Overview: $overview_text"
        rating.text = "Rating: $ratingtext"
        if (ratingtext.isNullOrEmpty()) {
            rating.text = "Rating: 1"
        } else {

            rating.text = "Rating: $ratingtext"
        }
    }
}