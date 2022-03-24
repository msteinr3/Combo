package com.example.firsttry

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.firsttry.databinding.ActivityMovieTicketsBinding
import java.lang.StringBuilder

class MovieTickets : AppCompatActivity() {

    private lateinit var binding : ActivityMovieTicketsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieTicketsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Movie Buttons
        var pricePerTicket = 0
        var movieName = ""
        var totalPrice = 0
        val grow: Animation = AnimationUtils.loadAnimation(this, R.anim.grow)

        binding.aladdinButton.setOnClickListener {
            binding.whichMovie.text = "Aladdin"
            movieName = "Aladdin"
            binding.summary.text = "The film follows the titular Aladdin, an Arabian street urchin, who finds a magic lamp containing a genie. He disguises himself as a wealthy prince and tries to impress the Sultan and his daughter, Princess Jasmine."
            pricePerTicket = 10
            binding.moviePrice.text = pricePerTicket.toString()

            binding.aladdinButton.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.whichMovie.startAnimation(grow)
            }
        }

        binding.avengersButton.setOnClickListener {
            binding.whichMovie.text = "Avengers"
            movieName = "Avengers"
            binding.summary.text =
                "Captain America, the Stark Enterprises created super soldier. Thor, the god of thunder, protector of Earth and his home planet of Asgard, and Loki's brother. Master assassins Hawkeye and Natasha Romanoff. Together they will become a team to take on an attack that will call them to become the greatest of all time."
            pricePerTicket = 18
            binding.moviePrice.text = pricePerTicket.toString()

            binding.avengersButton.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.whichMovie.startAnimation(grow)
            }

        }
        binding.batmanButton.setOnClickListener {
            binding.whichMovie.text = "Batman"
            movieName = "Batman: Dark Knight"
            binding.summary.text =
                "A gang of criminals rob a Gotham City mob bank; the Joker manipulates them into murdering each other for a higher share until only he remains and escapes with the money. Batman, District Attorney Harvey Dent and Lieutenant Jim Gordon form an alliance to rid Gotham of organized crime."
            pricePerTicket = 16
            binding.moviePrice.text = pricePerTicket.toString()

            binding.batmanButton.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.whichMovie.animate().apply {
                    binding.whichMovie.startAnimation(grow)
                }
            }
        }
        binding.frozenButton.setOnClickListener {
            binding.whichMovie.text = "Frozen"
            movieName = "Frozen"
            binding.summary.text =
                "When the newly crowned Queen Elsa accidentally uses her power to turn things into ice to curse her home in infinite winter, her sister Anna teams up with a mountain man, his playful reindeer, and a snowman to change the weather condition."
            pricePerTicket = 10
            binding.moviePrice.text = pricePerTicket.toString()

            binding.frozenButton.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.whichMovie.animate().apply {
                    binding.whichMovie.startAnimation(grow)
                }
            }
        }
        binding.hpButton.setOnClickListener {
            binding.whichMovie.text = "Harry Potter"
            movieName = "Harry Potter and the Sorcerer's stone"
            binding.summary.text =
                "On his 11th birthday, Harry receives a letter inviting him to study magic at the Hogwarts School of Witchcraft and Wizardry. Harry discovers that not only is he a wizard, but he is a famous one. He meets two best friends, Ron Weasley and Hermione Granger, and makes his first enemy, Draco Malfoy."
            pricePerTicket = 13
            binding.moviePrice.text = pricePerTicket.toString()

            binding.hpButton.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.whichMovie.animate().apply {
                    binding.whichMovie.startAnimation(grow)
                }
            }
        }
        binding.lionButton.setOnClickListener {
            binding.whichMovie.text="The Lion King"
            movieName = "The Lion King"
            binding.summary.text =
                "The Lion King tells the story of Simba (Swahili for lion), a young lion who is to succeed his father, Mufasa, as King of the Pride Lands; however, after Simba's paternal uncle Scar murders Mufasa to seize the throne, Simba is manipulated into thinking he was responsible and flees into exile."
            pricePerTicket = 9
            binding.moviePrice.text = pricePerTicket.toString()

            binding.lionButton.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.whichMovie.animate().apply {
                    binding.whichMovie.startAnimation(grow)
                }
            }
        }
        binding.lotrButton.setOnClickListener {
            binding.whichMovie.text = "The Lord of the Rings"
            movieName = "The Lord of the Rings: \nFellowship of the Ring"
            binding.summary.text =
                "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron. An ancient Ring thought lost for centuries has been found, and through a strange twist of fate has been given to a small Hobbit named Frodo."
            pricePerTicket = 16
            binding.moviePrice.text = pricePerTicket.toString()

            binding.lotrButton.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.whichMovie.animate().apply {
                    binding.whichMovie.startAnimation(grow)
                }
            }
        }
        binding.moanaButton.setOnClickListener {
            binding.whichMovie.text= "Moana"
            movieName = "Moana"
            binding.summary.text =
                "An adventurous teenager sails out on a daring mission to save her people. During her journey, Moana meets the once-mighty demigod Maui, who guides her in her quest to become a master wayfinder. Together, they sail across the open ocean on an action-packed voyage, encountering enormous monsters and impossible odds."
            pricePerTicket = 9
            binding.moviePrice.text = pricePerTicket.toString()

            binding.moanaButton.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.whichMovie.animate().apply {
                    binding.whichMovie.startAnimation(grow)
                }
            }
        }
        binding.mulanButton.setOnClickListener {
            binding.whichMovie.text = "Mulan"
            movieName = "Mulan"
            binding.summary.text =
                "Mulan is a girl, the only child of her honored family. When the Huns invade China, one man from every family is called to arms. Mulan's father, who has an old wound and cannot walk properly, decides to fight for his country and the honor of his family though it is clear that he will not survive an enemy encounter."
            pricePerTicket = 7
            binding.moviePrice.text = pricePerTicket.toString()

            binding.mulanButton.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.whichMovie.animate().apply {
                    binding.whichMovie.startAnimation(grow)
                }
            }
        }
        binding.notebookButton.setOnClickListener {
            binding.whichMovie.text = "The Notebook"
            movieName = "The Notebook"
            binding.summary.text =
                "The Notebook is an achingly tender story about the enduring power of love, a story of miracles that will stay with you forever. Set amid the austere beauty of coastal North Carolina in 1946, The Notebook begins with the story of Noah Calhoun, a rural Southerner returned home from World War II."
            pricePerTicket = 12
            binding.moviePrice.text = pricePerTicket.toString()

            binding.notebookButton.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.whichMovie.animate().apply {
                    binding.whichMovie.startAnimation(grow)
                }
            }
        }
        binding.piratesButton.setOnClickListener {
            binding.whichMovie.text = "Pirates of the Caribbean"
            movieName = "Pirates of the Caribbean: \nDead Man's Chest"
            binding.summary.text =
                "William Turner, a resourceful young blacksmith, teams up with the eccentric pirate \"Captain\" Jack Sparrow to save his love, the Governor's daughter, Elizabeth Swann, who has been mistakenly captured by the clever and treacherous Barbossa, a former ally of Jack, to make a blood sacrifice so as to end the curse that has been casted upon him and his crew. Will and Jack steal a ship from the Royal Navy and arrive at Tortuga, a pirate port. There Jack meets his friend Joshamee Gibbs and with a buccaneer and \"able bodied\" crew, set sail to save Elizabeth and take back the Black Pearl. Meanwhile, Barbossa discovers that not Elizabeth's but someone else's blood was required for the sacrifice. Whose blood is it?"
            pricePerTicket = 14
            binding.moviePrice.text = pricePerTicket.toString()

            binding.piratesButton.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.whichMovie.animate().apply {
                    binding.whichMovie.startAnimation(grow)
                }
            }
        }
        binding.toysButton.setOnClickListener {
            binding.whichMovie.text = "Toy Story"
            movieName = "Toy Story"
            binding.summary.text =
                "A cowboy doll is profoundly threatened and jealous when a new spaceman figure supplants him as top toy in a boy's room. A little boy named Andy loves to be in his room, playing with his toys, especially his doll named \"Woody\". But, what do the toys do when Andy is not with them, they come to life."
            pricePerTicket = 8
            binding.moviePrice.text = pricePerTicket.toString()

            binding.toysButton.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.whichMovie.animate().apply {
                    binding.whichMovie.startAnimation(grow)
                }
            }
        }

        //Everything else
        var dateChosen = ""
        var adultChild = ""
        var amount = ""
        var numOfTickets = 0
        var clicked = 0

        binding.calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val day = dayOfMonth.toString()
            val year = year.toString()
            val month = (month + 1).toString()
            binding.dateClicked.text = "$day/$month/$year"
            dateChosen = "$day/$month/$year"
        }

        binding.ageResult.setOnCheckedChangeListener { _, _ ->
            adultChild = if (binding.adult.isChecked) {
                "Adult"
            } else {
                "Minor"
            }
        }

        binding.numTickets.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                numOfTickets = s.toString().toInt()
                amount = numOfTickets.toString()
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        binding.buy.setOnClickListener {
            if (movieName == "" || amount == "" || adultChild == "" || dateChosen == "") {
                val builder = StringBuilder("Missing info:\n")
                if (movieName.isEmpty()) {
                    builder.append("Movie, ")
                }
                if (amount.isEmpty()) {
                    builder.append("# of tickets, ")
                }
                if (adultChild.isEmpty()) {
                    builder.append("Minor, ")
                }
                if (dateChosen.isEmpty()) {
                    builder.append("Date")
                }
                Toast.makeText(this, builder.toString(), Toast.LENGTH_LONG).show()

            } else {
                //calculate total
                val cost = numOfTickets * pricePerTicket
                totalPrice = if (adultChild == "Minor") {
                    cost / 2
                } else {
                    cost
                }
                clicked = 1
                binding.movieTitle.text = movieName
                binding.number.text = "Number of tickets: $amount"
                binding.age.text = adultChild
                binding.date.text = "date: $dateChosen"
                binding.price.text = "Total: $$totalPrice"
                binding.ticket.setImageResource(R.drawable.emptytix)
            }
        }

        binding.confirm.setOnClickListener {
            if (clicked == 0) {
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Confirmation")
                builder.setMessage("Are you sure you want to confirm purchase?")
                builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()

                    val build = AlertDialog.Builder(this)
                    build.setTitle("Confirmed")
                    build.setMessage("Enjoy $movieName")
                    build.setIcon(R.drawable.ic_baseline_check_circle_24)
                    build.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                    })
                    val alert = build.create()
                    alert.setTitle("Confirmed")
                    alert.show()
                })
                builder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()
                })
                val alert = builder.create()
                alert.setTitle("Confirmation")
                alert.show()
            }
        }

        val actionbar = supportActionBar
        actionbar!!.title = "Movie Tickets"

        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}


