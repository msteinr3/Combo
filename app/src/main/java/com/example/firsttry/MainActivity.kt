package com.example.firsttry

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //list stuff
        val listView = findViewById<ListView>(R.id.list)
        var array = arrayOf("Movie Tickets", "Restaurants", "Fashion", "Drawing", "Tic Tac Toe", "Swag Swag")
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
            if (position == 4) {
                val intent = Intent(this, Tic_Tac_Toe::class.java)
                startActivity(intent)
            }
            if (position == 5) {
                val intent = Intent(this, Swag::class.java)
                startActivity(intent)
            }
        }

        //sound stuff
        var mMediaPlayer: MediaPlayer? = null

        // 0. Plays sound
        fun playSound() {
            if (mMediaPlayer == null) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.tada)
                mMediaPlayer!!.isLooping = false
                mMediaPlayer!!.start()
            } else mMediaPlayer!!.start()
        }

        // 1. Plays sound on loop
        fun playSoundLooped() {
            if (mMediaPlayer == null) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.the_light)
                mMediaPlayer!!.isLooping = true
                mMediaPlayer!!.start()
            } else mMediaPlayer!!.start()
        }

        // 2. Pause playback
        fun pauseSound() {
            if (mMediaPlayer?.isPlaying == true) mMediaPlayer?.pause()
        }

        // 3. Stops playback
        fun stopSound() {
            if (mMediaPlayer != null) {
                mMediaPlayer!!.stop()
                mMediaPlayer!!.release()
                mMediaPlayer = null
            }
        }

        // 4. Destroys the MediaPlayer instance when the app is closed
        fun onStop() {
            super.onStop()
            if (mMediaPlayer != null) {
                mMediaPlayer!!.release()
                mMediaPlayer = null
            }
        }

        val play = findViewById<Switch>(R.id.sound_on)
        val sound = findViewById<ImageView>(R.id.sound)
        val on_off = findViewById<TextView>(R.id.on_off)

        play.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sound.setImageResource(R.drawable.ic_baseline_volume_up_24)
                on_off.text = "Sound: On"
                playSoundLooped()
            } else {
                sound.setImageResource(R.drawable.ic_baseline_volume_off_24)
                on_off.text = "Sound: Off"
                pauseSound()
            }
        }
    }
}

