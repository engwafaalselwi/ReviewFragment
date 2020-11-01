package com.example.reviewfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() ,ColorFragment.Callbacks ,ColorFragment2.Callbacks{
    private lateinit var red : Button
    private lateinit var green : Button
    private lateinit var blue : Button

    private lateinit var ColorTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        red = findViewById(R.id.red)
        green =findViewById(R.id.green)
        blue = findViewById(R.id.blue)

        red.setOnClickListener {
            SendColorName("red")
        }

        green.setOnClickListener {
            SendColorName("green")
        }

        blue.setOnClickListener {
            SendColorName("blue")
        }
        ColorTextView = findViewById(R.id.color_text)
    }

    fun SendColorName (color : String){
        val currentFragment : Fragment? = supportFragmentManager.findFragmentById(R.id.frame)
        if(currentFragment == null){
            val fragment = ColorFragment.newInstance(color)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame,fragment)
                .commit()
        }
    }

    override fun onClick(Colorfrag: String) {
        val currentFragment=supportFragmentManager.findFragmentById(R.id.Colorframe)
        if(currentFragment==null){
            val fragment =ColorFragment2.newInstance(Colorfrag)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.Colorframe,fragment)
                .addToBackStack(null)
                .commit()



        }
    }
}