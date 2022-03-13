package com.example.firsttry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Fashion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fashion)

        //start here

        val blackShirt = ItemData("blackshirt", 5, "Guess", "Black shirt", 0)
        val blueShirt = ItemData("blueshirt", 5, "Guess", "Blue shirt", 0)
        val pants = ItemData("pants", 5, "idk", "Khaki pants", 0)
        val jeans = ItemData("jeans", 5, "Levi", "Jeans", 0)
        val blackDress = ItemData("blackdress", 5, "Guess", "Black dress", 0)
        val blueDress = ItemData("blueshirt", 5, "Guess", "Blue dress", 0)
        val shoes = ItemData("shoes", 5, "Nike", "Shoes", 0)
        val boots = ItemData("boots", 5, "Blundtstone", "Brown Blundtstone boots", 0)

        val array = arrayOf(blackShirt, blueShirt, pants, jeans, blackDress, blueDress, shoes, boots)



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