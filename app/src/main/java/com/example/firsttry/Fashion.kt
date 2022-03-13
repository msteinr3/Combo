package com.example.firsttry

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class Fashion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fashion)

        //items
        val blackShirt = ItemData("blackshirt", 5, "Guess", "Black shirt", 0)
        val blueShirt = ItemData("blueshirt", 5, "Guess", "Blue shirt", 0)
        val pants = ItemData("pants", 12, "idk", "Khaki pants", 0)
        val jeans = ItemData("jeans", 15, "Levi", "Jeans", 0)
        val blackDress = ItemData("blackdress", 30, "Guess", "Black dress", 0)
        val blueDress = ItemData("blueshirt", 40, "Guess", "Blue dress", 0)
        val shoes = ItemData("shoes", 50, "Nike", "Shoes", 0)
        val boots = ItemData("boots", 80, "Blundtstone", "Brown Blundtstone boots", 0)

        val array = arrayOf(blackShirt, blueShirt, pants, jeans, blackDress, blueDress, shoes, boots)

        //translate array to gridview using layout item_data
        //pic is the name of the image
        //text under is price, brand, description
        //when we click each one, clicked should change to 1, highlight the background, add to cart
        //long click, switches clicked back to 0, unhighlight, remove from cart
        //do the gridview items need to be buttons? change layout?



        val confirm = findViewById<Button>(R.id.confirm)

        confirm.setOnClickListener {
            //if (clicked == 0) {
           // } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Confirmation")
                builder.setMessage("Are you sure you want to confirm purchase?")
                builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()

                    val intent = Intent(this, Confirmation::class.java)
                    startActivity(intent)
                })
                builder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()
                    //pic.setImageResource(android.R.color.transparent)
                })
                val alert = builder.create()
                alert.setTitle("Confirmation")
                alert.show()
            //}
        }

        val actionbar = supportActionBar
        actionbar!!.title = "Fashion"

        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

data class ItemData (val pic:String, val price:Int, val brand:String, val description:String, var clicked:Int)