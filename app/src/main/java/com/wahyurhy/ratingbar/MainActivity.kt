package com.wahyurhy.ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.wahyurhy.ratingbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var myRating = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b ->

                val rating = fl.toInt()
                var message = ""

                myRating = ratingBar.rating

                when (rating) {
                    1 -> {
                        message = "Sorry to hear that! :("
                    }
                    2 -> {
                        message = "You always accept suggestions!"
                    }
                    3 -> {
                        message = "Good enough!"
                    }
                    4 -> {
                        message = "Great! Thank you!"
                    }
                    5 -> {
                        message = "Awesome! You are the best!"
                    }
                    else -> {
                        message = "I apologize to you for that :'"
                    }
                }

                Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
            }

            button.setOnClickListener {
                Toast.makeText(this@MainActivity, "Your rating is: $myRating", Toast.LENGTH_SHORT).show()
            }
        }
    }
}