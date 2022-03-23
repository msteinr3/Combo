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
import java.lang.StringBuilder

class Restaurants : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)

        //movie buttons
        val pizzaBtn = findViewById<ImageButton>(R.id.pizza)
        val burgerBtn = findViewById<ImageButton>(R.id.burger)
        val friesBtn = findViewById<ImageButton>(R.id.fries)
        val cakeBtn = findViewById<ImageButton>(R.id.cake)
        val spriteBtn = findViewById<ImageButton>(R.id.sprite)
        val fantaBtn = findViewById<ImageButton>(R.id.fanta)

        val item = findViewById<TextView>(R.id.item)
        val itemPrice = findViewById<TextView>(R.id.price)
        val description = findViewById<TextView>(R.id.description)

        var pricePerItem = 0
        var itemName = ""
        var totalPrice = 0

        val grow: Animation = AnimationUtils.loadAnimation(this, R.anim.grow)

        pizzaBtn.setOnClickListener {
            item.setText("Pizza")
            itemName = "Aladdin"
            description.text ="Cheese pizza"
            pricePerItem = 20
            itemPrice.text = pricePerItem.toString()

            pizzaBtn.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                item.startAnimation(grow)
            }
        }

        burgerBtn.setOnClickListener {
            item.setText("Hamburger")
            itemName = "Burger"
            description.text ="Cheese burger"
            pricePerItem = 10
            itemPrice.text = pricePerItem.toString()

            burgerBtn.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                item.startAnimation(grow)
            }
        }
        friesBtn.setOnClickListener {
            item.setText("French Fries")
            itemName = "French Fries"
            description.text ="French Fries"
            pricePerItem = 5
            itemPrice.text = pricePerItem.toString()

            friesBtn.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                item.startAnimation(grow)
            }
        }
        cakeBtn.setOnClickListener {
            item.setText("Cake")
            itemName = "Cake"
            description.text ="1 slice of Chocolate cake"
            pricePerItem = 6
            itemPrice.text = pricePerItem.toString()

            cakeBtn.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                item.startAnimation(grow)
            }
        }
        spriteBtn.setOnClickListener {
            item.setText("Sprite")
            itemName = "Sprite"
            description.text ="Lemon lime soda"
            pricePerItem = 3
            itemPrice.text = pricePerItem.toString()

            spriteBtn.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                item.startAnimation(grow)
            }
        }
        fantaBtn.setOnClickListener {
            item.setText("Fanta")
            itemName = "Fanta"
            description.text ="Orange soda"
            pricePerItem = 3
            itemPrice.text = pricePerItem.toString()

            fantaBtn.animate().apply {
                duration = 1000
                rotationYBy(360f)
            }.withEndAction {
                item.startAnimation(grow)
            }
        }

        //other stuff
        val restrictions = findViewById<RadioGroup>(R.id.restrictions)
        val rVegan = findViewById<RadioButton>(R.id.vegan)
        var vegan = ""

        restrictions.setOnCheckedChangeListener { _, _ ->
            vegan = if (rVegan.isChecked) {
                "Vegan"
            } else {
                "Carnivore"
            }
        }

        val payment = findViewById<RadioGroup>(R.id.paymentMethod)
        val rCredit = findViewById<RadioButton>(R.id.credit)
        var credit = ""

        payment.setOnCheckedChangeListener { _, _ ->
            credit = if (rCredit.isChecked) {
                "Credit/Debit"
            } else {
                "Cash"
            }
        }

        val time = findViewById<TimePicker>(R.id.time)
        val timeClicked = findViewById<TextView>(R.id.timeClicked)
        time.setIs24HourView(false)
        var ampm = ""
        var timeChosen = ""
        time.setOnTimeChangedListener { _, hour, minutes, ->
            ampm = if (hour < 12) {"am"} else {"pm"}
            val hour = if (hour == 0 || hour == 12) {"12"} else {(hour%12).toString()}
            val minutes = if (minutes < 10) {
                "0$minutes"
            } else {
                minutes.toString()
            }
            timeClicked.text = "$hour:$minutes $ampm"
            timeChosen = "$hour:$minutes $ampm"
        }

        val numSeats = findViewById<EditText>(R.id.numSeats)
        var numOfSeats = 0
        var amount = ""

        numSeats.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                numOfSeats = s.toString().toInt()
                amount = numOfSeats.toString()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        val restaurant = findViewById<EditText>(R.id.restaurant)
        var name = ""

        restaurant.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                name = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        val reserve = findViewById<Button>(R.id.reserve)
        val restaurantName = findViewById<TextView>(R.id.restaurantName)
        val resTime = findViewById<TextView>(R.id.resTime)
        val seats = findViewById<TextView>(R.id.seats)
        val diet = findViewById<TextView>(R.id.diet)
        val pay = findViewById<TextView>(R.id.pay)
        val pic = findViewById<ImageView>(R.id.reserved)

        reserve.setOnClickListener {
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
                restaurantName.text = name
                resTime.text = "Time: $timeChosen"
                seats.text = "Number of seats: $amount"
                diet.text = "Dietary restrictions: $vegan"
                pay.text = "Payment: $credit"
                pic.setImageResource(R.drawable.reserved)
            }
        }

        val actionbar = supportActionBar
        actionbar!!.title = "Restaurants"

        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
