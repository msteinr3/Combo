package com.example.firsttry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Drawing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawing)

        //do something

        val actionbar = supportActionBar
        actionbar!!.title = "Drawing"

        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
