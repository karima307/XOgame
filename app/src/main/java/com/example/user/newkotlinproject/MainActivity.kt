package com.example.user.newkotlinproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //textDisplay.text="hhhhhhh"
        btn.setOnClickListener( {
            getAge()
        })
        btn2.setOnClickListener({
            val intent=Intent(applicationContext,TicTacToe::class.java)
            startActivity(intent)
        })
    }
    fun getAge(){

        val yearOfBirth:Int=editText1.text.toString().toInt()
        //process
        var year:Int= Calendar.getInstance().get(Calendar.YEAR)

        var yearAge=year-yearOfBirth
       textDisplay.text=yearAge.toString()

    }
}
