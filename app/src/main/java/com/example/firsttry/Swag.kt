package com.example.firsttry

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import com.example.firsttry.databinding.ActivityMovieTicketsBinding
import com.example.firsttry.databinding.ActivitySwagBinding

class Swag : AppCompatActivity() {

    private lateinit var binding : ActivitySwagBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwagBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Sound stuff
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

        binding.maya.setOnClickListener {
            if (binding.maya.tag == "off") {
                playSound1()
                binding.maya.tag = "on"
                binding.shirt.setImageResource(R.drawable.maya)
            } else {
                pauseSound()
                binding.maya.tag = "off"
            }
        }

        binding.benji.setOnClickListener {
            if (binding.benji.tag == "off") {
                playSound2()
                binding.benji.tag = "on"
                binding.shirt.setImageResource(R.drawable.daniella)
            } else {
                pauseSound2()
                binding.benji.tag = "off"
            }
        }

        //Back button
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
