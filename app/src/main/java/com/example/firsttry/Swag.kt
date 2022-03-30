package com.example.firsttry

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.firsttry.databinding.ActivitySwagBinding

/**
 * ? - nullable type
 * !! - "It might be null, but I am sure it isnt!, So I am accessing the referencing as if it is NOT a nullable type.
 * ! - Platform Type. Some function we use in Kotlin are written in Java. Java doesn't have nullability safety.
 *      But in Kotlin, we do have it. Kotlin needs information about the nullability of the object.
 *      So in order to treat functions and object that came from Java, we have the "!" symbol which means:
 *      "It might be null, But I can access it as if it isn't
 */

class Swag : AppCompatActivity() {

    private lateinit var binding : ActivitySwagBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwagBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Sound and video stuff
        var mp: MediaPlayer? = null
        var vp : MediaController? = null
        var songs = arrayOf(R.raw.champaign, R.raw.howl, R.raw.tvd1, R.raw.tvd2, R.raw.tada, R.raw.dog, R.raw.duck, R.raw.moo)
        var videos = arrayOf(R.raw.delena, R.raw.booty)
        var playing = "nobody"

        //Don't show videoView on start
        binding.video?.visibility = View.INVISIBLE

        fun playSound(song: Int) {
            if (mp == null) {
                mp = MediaPlayer.create(this, song)
                mp!!.isLooping = true
                mp!!.start()
            } else mp!!.start()
        }

        fun pauseSound() {
            if (mp?.isPlaying == true) mp?.pause()
        }

        fun stopSound() {
            if (mp != null) {
                mp!!.stop()
                mp!!.release()
                mp = null
            }
        }

        fun playVideo(video: Int) {
            if (vp == null) {
                vp = MediaController(this)
                vp?.setAnchorView(binding.video)
            }
                binding.video.setMediaController(vp)
                binding.video.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + video))
                binding.video.requestFocus()
                binding.video.start()
        }

        fun stopVideo() {
            if (vp != null) {
                binding.video.stopPlayback()
                vp = null
                binding.video.visibility = View.INVISIBLE
            }
        }

        binding.video.setOnCompletionListener {
            stopVideo()
        }

        //Buttons
        binding.info.setOnClickListener {
            Toast.makeText(this, "Tap people to play/pause \nLong click Maya to end song", Toast.LENGTH_LONG).show()
        }

        binding.maya.setOnClickListener {
            binding.shirttxt.text= "Maya"
            binding.shirt.setImageResource(R.drawable.maya)
            if (binding.maya.tag == "off" && (playing == "nobody" || playing == "benji")) {
                playSound(songs[0])
                playing = "maya"
                binding.maya.tag = "on"
            } else if (playing == "maya") {
                pauseSound()
                binding.maya.tag = "off"
            }
        }

        binding.maya.setOnLongClickListener {
            stopSound()
            stopVideo()
            playing = "nobody"
            binding.shirt.setImageResource(R.drawable.swag)
            binding.shirttxt.text = "Swag Swag"
            binding.maya.tag = "off"
            binding.benji.tag = "off"
            binding.daniella.tag = "off"
            binding.jake.tag = "off"
            binding.sarah.tag = "off"
            binding.jared.tag = "off"
            binding.grace.tag = "off"
            binding.elana.tag = "off"
            binding.menachem.tag = "off"
            binding.sol.tag = "off"
            binding.jori.tag = "off"
            binding.david.tag = "off"
            binding.rachel.tag = "off"
            true
        }

        binding.benji.setOnClickListener {
            binding.shirttxt.text="Benji"
            binding.shirt.setImageResource(R.drawable.benji)
            if (binding.benji.tag == "off" && (playing == "nobody" || playing == "benji")) {
                playSound(songs[1])
                binding.benji.tag = "on"
                playing = "benji"
            } else if (binding.benji.tag == "on" && playing == "benji") {
                pauseSound()
                binding.benji.tag = "off"
            }
        }

        binding.daniella.setOnClickListener {
            binding.shirttxt.text="Daniella"
            binding.shirt.setImageResource(R.drawable.daniella)
            if (binding.daniella.tag == "off" && (playing == "nobody" || playing == "benji")) {
                playSound(songs[2])
                playing = "daniella"
                binding.daniella.tag = "on"
            } else if (binding.daniella.tag == "on" && playing == "daniella") {
                pauseSound()
                binding.daniella.tag = "off"
            }
        }

        binding.jake.setOnClickListener {
            binding.shirttxt.text="Jake"
            binding.shirt.setImageResource(R.drawable.jake)
            if (binding.jake.tag == "off" && (playing == "nobody" || playing == "benji")) {
                playSound(songs[3])
                playing = "jake"
                binding.jake.tag = "on"
            } else if (binding.jake.tag == "on" && playing == "jake") {
                pauseSound()
                binding.jake.tag = "off"
            }
        }

        binding.sarah.setOnClickListener {
            binding.shirttxt.text="Sarah"
            binding.shirt.setImageResource(R.drawable.sarah)
            if (binding.sarah.tag == "off" && (playing == "nobody" || playing == "benji")) {
                playSound(songs[4])
                playing = "sarah"
                binding.sarah.tag = "on"
            } else if (binding.sarah.tag == "on" && playing == "sarah") {
                pauseSound()
                binding.sarah.tag = "off"
            }
        }

        binding.jared.setOnClickListener {
            binding.shirttxt.text="Jared"
            binding.shirt.setImageResource(R.drawable.jared)
            if (binding.jared.tag == "off" && (playing == "nobody" || playing == "benji")) {
                playSound(songs[5])
                playing = "jared"
                binding.jared.tag = "on"
            } else if (binding.jared.tag == "on" && playing == "jared") {
                pauseSound()
                binding.jared.tag = "off"
            }
        }

        binding.grace.setOnClickListener {
            binding.shirttxt.text="Grace"
            binding.shirt.setImageResource(R.drawable.grace)
            if (binding.grace.tag == "off" && (playing == "nobody" || playing == "benji")) {
                playSound(songs[6])
                playing = "grace"
                binding.grace.tag = "on"
            } else if (binding.grace.tag == "on" && playing == "grace") {
                pauseSound()
                binding.grace.tag = "off"
            }
        }

        binding.elana.setOnClickListener {
            binding.shirt.setImageResource(R.drawable.elana)
            if (playing == "nobody") {
                playing = "elana"
                binding.video?.visibility = View.VISIBLE
                playVideo(videos[0])
            }
        }

        binding.menachem.setOnClickListener {
            binding.shirttxt.text="Menachem"
            binding.shirt.setImageResource(R.drawable.menachem)
            if (binding.menachem.tag == "off" && (playing == "nobody" || playing == "benji")) {
                playSound(songs[5])
                playing = "menachem"
                binding.menachem.tag = "on"
            } else if (binding.menachem.tag == "on" && playing == "menachem") {
                pauseSound()
                binding.menachem.tag = "off"
            }
        }

        binding.sol.setOnClickListener {
            binding.shirt.setImageResource(R.drawable.sol)
            if (playing == "nobody") {
                playing = "sol"
                binding.video?.visibility = View.VISIBLE
                playVideo(videos[1])
            }
        }

        binding.jori.setOnClickListener {
            binding.shirttxt.text="Jori"
            binding.shirt.setImageResource(R.drawable.jori)
            if (binding.jori.tag == "off" && (playing == "nobody" || playing == "benji")) {
                playSound(songs[7])
                playing = "jori"
                binding.jori.tag = "on"
            } else if (binding.jori.tag == "on" && playing == "jori") {
                pauseSound()
                binding.jori.tag = "off"
            }
        }

        binding.david.setOnClickListener {
            binding.shirttxt.text="David"
            binding.shirt.setImageResource(R.drawable.david)
            if (binding.david.tag == "off" && (playing == "nobody" || playing == "benji")) {
                playSound(songs[4])
                playing = "david"
                binding.david.tag = "on"
            } else if (binding.david.tag == "on" && playing == "david") {
                pauseSound()
                binding.david.tag = "off"
            }
        }

        binding.rachel.setOnClickListener {
            binding.shirttxt.text="Rachel"
            binding.shirt.setImageResource(R.drawable.rachel)
            if (binding.rachel.tag == "off" && (playing == "nobody" || playing == "benji")) {
                playSound(songs[7])
                playing = "rachel"
                binding.rachel.tag = "on"
            } else if (binding.rachel.tag == "on" && playing == "rachel") {
                pauseSound()
                binding.rachel.tag = "off"
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