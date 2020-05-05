package com.example.justeatcake

import android.content.Intent
import android.icu.util.TimeUnit.values
import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.time.chrono.JapaneseEra.values

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener{ view ->showMap(view)}
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_map -> {
                showMap(null)
                true
            }
            R.id.action_delivery -> {
                Toast.makeText(this, "delivery", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_favourites -> {
                Toast.makeText(this, "favourites", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_contact -> {
                Toast.makeText(this, "contact", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    fun showMap(view: View?) {
        val intent: Intent = Intent().apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse(getString(R.string.justEatCakeLocation))
        }
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent)
        }
    }
}


// week 7 slide 33