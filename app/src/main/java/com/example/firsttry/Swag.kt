package com.example.firsttry

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Swag : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swag)

        val maya = findViewById<ImageButton>(R.id.maya)
        val benji = findViewById<ImageButton>(R.id.benji)
        val daniella = findViewById<ImageButton>(R.id.daniella)
        val jake = findViewById<ImageButton>(R.id.jake)
        val sarah = findViewById<ImageButton>(R.id.sarah)
        val jared = findViewById<ImageButton>(R.id.jared)
        val elana = findViewById<ImageButton>(R.id.elana)
        val david = findViewById<ImageButton>(R.id.david)
        val sol = findViewById<ImageButton>(R.id.sol)

        var mMediaPlayer: MediaPlayer? = null
        var bMediaPlayer: MediaPlayer? = null

        fun playSound1() {
            if (mMediaPlayer == null) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.the_light)
                mMediaPlayer!!.isLooping = false
                mMediaPlayer!!.start()
            } else mMediaPlayer!!.start()
        }

        fun playSound2() {
            if (bMediaPlayer == null) {
                bMediaPlayer = MediaPlayer.create(this, R.raw.tada)
                bMediaPlayer!!.isLooping = true
                bMediaPlayer!!.start()
            } else bMediaPlayer!!.start()
        }

        fun pauseSound() {
            if (mMediaPlayer?.isPlaying == true) mMediaPlayer?.pause()
        }

        fun pauseSound2() {
            if (bMediaPlayer?.isPlaying == true) bMediaPlayer?.pause()
        }

        maya.setOnClickListener {
            if (maya.tag == "off") {
                playSound1()
                maya.tag = "on"
            } else {
                pauseSound()
                maya.tag = "off"
            }
        }

        benji.setOnClickListener {
            if (benji.tag == "off") {
                playSound2()
                benji.tag = "on"
            } else {
                pauseSound2()
                benji.tag = "off"
            }
        }

        //set back button
        val actionbar = supportActionBar
        actionbar!!.title = "Swag Swag"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
