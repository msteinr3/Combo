package com.example.firsttry

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.firsttry.databinding.ActivityMainBinding
import com.example.firsttry.databinding.ActivityRestaurantsBinding
import java.lang.StringBuilder

class Restaurants : AppCompatActivity() {

    private lateinit var binding : ActivityRestaurantsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Variables
        var pricePerItem = 0
        var itemName = ""
        var vegan = ""
        var credit = ""
        var ampm = ""
        var timeChosen = ""
        var numOfSeats = 0
        var amount = ""
        var name = ""
        val grow: Animation = AnimationUtils.loadAnimation(this, R.anim.grow)

        //Food buttons
        binding.pizza.setOnClickListener {
            binding.item.setText("Pizza")
            itemName = "Pizza"
            binding.description.text ="Cheese pizza"
            pricePerItem = 20
            binding.price.text = pricePerItem.toString()

            binding.pizza.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.item.startAnimation(grow)
            }
        }

        binding.burger.setOnClickListener {
            binding.item.setText("Hamburger")
            itemName = "Burger"
            binding.description.text ="Cheese burger"
            pricePerItem = 10
            binding.price.text = pricePerItem.toString()

            binding.burger.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.item.startAnimation(grow)
            }
        }
        binding.fries.setOnClickListener {
            binding.item.setText("French Fries")
            itemName = "French Fries"
            binding.description.text ="French Fries"
            pricePerItem = 5
            binding.price.text = pricePerItem.toString()

            binding.fries.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.item.startAnimation(grow)
            }
        }
        binding.cake.setOnClickListener {
            binding.item.setText("Cake")
            itemName = "Cake"
            binding.description.text ="1 slice of Chocolate cake"
            pricePerItem = 6
            binding.price.text = pricePerItem.toString()

            binding.cake.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.item.startAnimation(grow)
            }
        }
        binding.sprite.setOnClickListener {
            binding.item.setText("Sprite")
            itemName = "Sprite"
            binding.description.text ="Lemon lime soda"
            pricePerItem = 3
            binding.price.text = pricePerItem.toString()

            binding.sprite.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                binding.item.startAnimation(grow)
            }
        }
        binding.fanta.setOnClickListener {
            binding.item.setText("Fanta")
            itemName = "Fanta"
            binding.description.text ="Orange soda"
            pricePerItem = 3
            binding.price.text = pricePerItem.toString()

            binding.fanta.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
               binding.item.startAnimation(grow)
            }
        }

        //Other stuff
        binding.restrictions.setOnCheckedChangeListener { _, _ ->
            vegan = if (binding.vegan.isChecked) {
                "Vegan"
            } else {
                "Carnivore"
            }
        }

        binding.paymentMethod.setOnCheckedChangeListener { _, _ ->
            credit = if (binding.credit.isChecked) {
                "Credit/Debit"
            } else {
                "Cash"
            }
        }

        binding.time.setIs24HourView(false)
        binding.time.setOnTimeChangedListener { _, hour, minutes, ->
            ampm = if (hour < 12) {"am"} else {"pm"}
            val hour = if (hour == 0 || hour == 12) {"12"} else {(hour%12).toString()}
            val minutes = if (minutes < 10) {
                "0$minutes"
            } else {
                minutes.toString()
            }
            binding.timeClicked.text = "$hour:$minutes $ampm"
            timeChosen = "$hour:$minutes $ampm"
        }

        binding.numSeats.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                numOfSeats = s.toString().toInt()
                amount = numOfSeats.toString()
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        binding.restaurant.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                name = s.toString()
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        binding.reserve.setOnClickListener {
            if (name == "" || timeChosen == "" || amount == "" || vegan == "" || credit == "") {
                val builder = StringBuilder("Missing information:\n")
                if (name.isEmpty()) {
                    builder.append("Restaurant")
                }
                if (timeChosen.isEmpty()) {
                    builder.append(", time")
                }
                if (amount.isEmpty()) {
                    builder.append("\n, # of seats")
                }
                if (vegan.isEmpty()) {
                    builder.append("\n, vegan")
                }
                if (credit.isEmpty()) {
                    builder.append("\n, payment method")
                }
                Toast.makeText(this, builder.toString(), Toast.LENGTH_LONG).show()

            } else {
                binding.restaurantName.text = name
                binding.resTime.text = "Time: $timeChosen"
                binding.seats.text = "Number of seats: $amount"
                binding.diet.text = "Dietary restrictions: $vegan"
                binding.pay.text = "Payment: $credit"
                binding.reserved.setImageResource(R.drawable.reserved)
            }
        }

        //Back button
        val actionbar = supportActionBar
        actionbar!!.title = "Restaurants"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
