package com.example.firsttry

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.firsttry.databinding.ActivitySwagBinding

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
                val uri = Uri.parse("android.resource://" + packageName + "/" + video)
                binding.video!!.setMediaController(vp)
                binding.video!!.setVideoURI(uri)
                binding.video!!.requestFocus()
                binding.video!!.start()
            }
        }

        fun stopVideo() {
            if (vp != null) {
                binding.video?.stopPlayback()
                vp = null
                binding.video?.visibility=View.INVISIBLE
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
            if (binding.maya.tag == "off") {
                playSound(songs[0])
                binding.maya.tag = "on"
            } else {
                pauseSound()
                binding.maya.tag = "off"
            }
        }

        binding.maya.setOnLongClickListener {
            stopSound()
            stopVideo()
            binding.shirt.visibility=View.VISIBLE
            binding.shirt.setImageResource(R.drawable.swag)
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
            if (binding.benji.tag == "off") {
                playSound(songs[1])
                binding.benji.tag = "on"
            } else {
                pauseSound()
                binding.benji.tag = "off"
            }
        }

        binding.daniella.setOnClickListener {
            binding.shirttxt.text="Daniella"
            binding.shirt.setImageResource(R.drawable.daniella)
            if (binding.daniella.tag == "off") {
                playSound(songs[2])
                binding.daniella.tag = "on"
            } else {
                pauseSound()
                binding.daniella.tag = "off"
            }
        }

        binding.jake.setOnClickListener {
            binding.shirttxt.text="Jake"
            binding.shirt.setImageResource(R.drawable.jake)
            if (binding.jake.tag == "off") {
                playSound(songs[3])
                binding.jake.tag = "on"
            } else {
                pauseSound()
                binding.jake.tag = "off"
            }
        }

        binding.sarah.setOnClickListener {
            binding.shirttxt.text="Sarah"
            binding.shirt.setImageResource(R.drawable.sarah)
            if (binding.sarah.tag == "off") {
                playSound(songs[4])
                binding.sarah.tag = "on"
            } else {
                pauseSound()
                binding.sarah.tag = "off"
            }
        }

        binding.jared.setOnClickListener {
            binding.shirttxt.text="Jared"
            binding.shirt.setImageResource(R.drawable.jared)
            if (binding.jared.tag == "off") {
                playSound(songs[5])
                binding.jared.tag = "on"
            } else {
                pauseSound()
                binding.jared.tag = "off"
            }
        }

        binding.grace.setOnClickListener {
            binding.shirttxt.text="Grace"
            binding.shirt.setImageResource(R.drawable.grace)
            if (binding.grace.tag == "off") {
                playSound(songs[6])
                binding.grace.tag = "on"
            } else {
                pauseSound()
                binding.grace.tag = "off"
            }
        }

        binding.elana.setOnClickListener {
            binding.shirt.visibility= View.INVISIBLE
            binding.video?.visibility=View.VISIBLE
            playVideo(videos[0])
        }

        binding.menachem.setOnClickListener {
            binding.shirttxt.text="Menachem"
            binding.shirt.setImageResource(R.drawable.menachem)
            if (binding.menachem.tag == "off") {
                playSound(songs[5])
                binding.menachem.tag = "on"
            } else {
                pauseSound()
                binding.menachem.tag = "off"
            }
        }

        binding.sol.setOnClickListener {
            binding.shirt.visibility= View.INVISIBLE
            binding.video?.visibility=View.VISIBLE
            playVideo(videos[1])
        }

        binding.jori.setOnClickListener {
            binding.shirttxt.text="Jori"
            binding.shirt.setImageResource(R.drawable.jori)
            if (binding.jori.tag == "off") {
                playSound(songs[7])
                binding.jori.tag = "on"
            } else {
                pauseSound()
                binding.jori.tag = "off"
            }
        }

        binding.david.setOnClickListener {
            binding.shirttxt.text="David"
            binding.shirt.setImageResource(R.drawable.david)
            if (binding.david.tag == "off") {
                playSound(songs[4])
                binding.david.tag = "on"
            } else {
                pauseSound()
                binding.david.tag = "off"
            }
        }

        binding.rachel.setOnClickListener {
            binding.shirttxt.text="Rachel"
            binding.shirt.setImageResource(R.drawable.rachel)
            if (binding.rachel.tag == "off") {
                playSound(songs[7])
                binding.rachel.tag = "on"
            } else {
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
