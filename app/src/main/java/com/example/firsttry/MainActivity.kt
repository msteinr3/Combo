package com.example.firsttry

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.lang.StringBuilder
import kotlin.text.toInt as toInt1


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val slide: Animation = AnimationUtils.loadAnimation(this, R.anim.slide_in)

        val listView = findViewById<ListView>(R.id.list)
        var array = arrayOf("Movie Tickets", "Restaurants", "Fashion", "Other")
        val adapter = ArrayAdapter(this, R.layout.listview_item, array)

        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->

            if (position == 0) {
                val intent = Intent(this, MovieTickets::class.java)
                startActivity(intent)
            }
            if (position == 1) {
                val intent = Intent(this, Restaurants::class.java)
                startActivity(intent)
            }
            if (position == 2) {
                val intent = Intent(this, Fashion::class.java)
                startActivity(intent)
            }
            if (position == 3) {
                val intent = Intent(this, Drawing::class.java)
                startActivity(intent)
            }
        }
    }
}

