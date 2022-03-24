package com.example.firsttry

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.firsttry.databinding.ActivityMainBinding
import com.example.firsttry.databinding.ActivityMovieTicketsBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //list stuff
        var array = arrayOf("Movie Tickets", "Restaurants", "Fashion", "Drawing", "Tic Tac Toe", "Swag Swag")
        val adapter = ArrayAdapter(this, R.layout.listview_item, array)

        binding.list.adapter = adapter
        binding.list.setOnItemClickListener { parent, view, position, id ->

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

        binding.play.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.sound.setImageResource(R.drawable.ic_baseline_volume_up_24)
                binding.onOff.text = "Sound: On"
                playSoundLooped()
            } else {
                binding.sound.setImageResource(R.drawable.ic_baseline_volume_off_24)
                binding.onOff.text = "Sound: Off"
                pauseSound()
            }
        }
    }
}

