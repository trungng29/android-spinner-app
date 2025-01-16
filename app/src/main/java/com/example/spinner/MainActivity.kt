package com.example.spinner

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var main: ConstraintLayout

    lateinit var spinner: Spinner
    lateinit var imageView: ImageView
    lateinit var title: TextView
    lateinit var switch: Switch


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinner = findViewById(R.id.spinner)
        imageView = findViewById(R.id.imageView4)
        title = findViewById(R.id.textView)
        switch = findViewById(R.id.switch1)

        main = findViewById(R.id.main)

        spinner.onItemSelectedListener = this

        val arrayAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.Movies,
            android.R.layout.test_list_item
        )

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter

        val darkModeColor = ContextCompat.getColor(this, R.color.dark_mode)

        switch.setOnClickListener {
            if (switch.isChecked ) {
                main.setBackgroundColor(Color.WHITE)
                switch.text = "Light"
                spinner.setBackgroundColor(darkModeColor)
                title.setTextColor(darkModeColor)
            }
            else {
                main.setBackgroundColor(darkModeColor)
                switch.text = "Dark"
                spinner.setBackgroundColor(Color.WHITE)
                title.setTextColor(darkModeColor)
            }
        }

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        title.text = parent!!.getItemAtPosition(position).toString()

        if ( title.text == "Howl's moving castle" ) {
            imageView.setImageResource(R.drawable.howl)
        }
        else if ( title.text == "Spirited Away" ) {
            imageView.setImageResource(R.drawable.spirited_away)
        }
        else if ( title.text == "The whisper of the heart" ) {
            imageView.setImageResource(R.drawable.whisper_of_the_heart)
        }
        else if ( title.text == "The cat's return" ) {
            imageView.setImageResource(R.drawable.cat)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}