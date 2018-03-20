package com.example.user.newkotlinproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.tictac.*

import java.util.*

/**
 * Created by user on 3/19/2018.
 */
public class TicTacToe:AppCompatActivity(){
    var buclick=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tictac)

    }
fun checkbuttonclick(view:View):Button{
    val btnclick= view as Button

    when(btnclick.id){
        R.id.btn11-> buclick=1
        R.id.btn12-> buclick=2
        R.id.btn13->buclick=3
        R.id.btn21->buclick=4
        R.id.btn22->buclick=5
        R.id.btn23->buclick=6
        R.id.btn31->buclick=7
        R.id.btn32->buclick=8
        R.id.btn33->buclick=9
    }
    return btnclick
}
      fun onclick(view: View){

          val btnclick=checkbuttonclick(view)
        Log.d("*******",buclick.toString())
          play(buclick,btnclick)
          chceckWinner(view)
    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activePlayer=1
    fun play(buclick:Int,btnclick:Button){

        if(activePlayer==1){
            btnclick.setBackgroundResource(R.color.color2)
            btnclick.text="X"
            player1.add(buclick)
            activePlayer=2
            autoPlay()
        }else{
            btnclick.setBackgroundResource(R.color.color1)
            btnclick.text="O"
            player2.add(buclick)
            activePlayer=1

        }
        btnclick.isEnabled=false
    }
     fun chceckWinner(view:View){
         val btnclick= checkbuttonclick( view)
        var winner=-1
         //rows
         if(player1.contains(1) && player1.contains(2)&& player1.contains(3)){
             winner=1
             btnclick.isEnabled=false

         }
         if(player2.contains(1) && player2.contains(2)&& player2.contains(3)){
            winner=2
             btnclick.isEnabled=false
         }
         if(player1.contains(4) && player1.contains(5)&& player1.contains(6)){
             winner=1
             btnclick.isEnabled=false
         }
         if(player2.contains(4) && player2.contains(5)&& player2.contains(6)){
             winner=2
             btnclick.isEnabled=false

         }
         if(player1.contains(7) && player1.contains(8)&& player1.contains(9)){
             winner=1
             btnclick.isEnabled=false
         }
         if(player2.contains(7) && player2.contains(8)&& player2.contains(9)){
             winner=2
             btnclick.isEnabled=false
         }
         //cols
         if(player1.contains(1) && player1.contains(4)&& player1.contains(7)){
             winner=1
             btnclick.isEnabled=false
         }
         if(player2.contains(1) && player2.contains(4)&& player2.contains(7)){
             winner=2
             btnclick.isEnabled=false
         }
         if(player1.contains(2) && player1.contains(5)&& player1.contains(8)){
             winner=1
             btnclick.isEnabled=false
         }
         if(player2.contains(2) && player2.contains(5)&& player2.contains(8)){
             winner=2
             btnclick.isEnabled=false

         }
         if(player1.contains(3) && player1.contains(6)&& player1.contains(9)){
             winner=1
             btnclick.isEnabled=false
         }
         if(player2.contains(3) && player2.contains(6)&& player2.contains(9)){
             winner=2
             btnclick.isEnabled=false
         }
         if(winner!=-1){
             if(winner==1){
                 Toast.makeText(applicationContext,"winner is X",Toast.LENGTH_LONG).show()
             }
             else{
                 Toast.makeText(applicationContext,"winner is O ",Toast.LENGTH_LONG).show()

             }
         }
    }
    fun autoPlay(){
        val emptyCell=ArrayList<Int>()
        for(buclick in 1..9){
            if(!(player1.contains(buclick)|| player2.contains(buclick))){
                emptyCell.add(buclick)
            }
        }
        val r=Random()
        val rand=r.nextInt(emptyCell.size-1)+1
        val cellID =emptyCell[rand]
        var bueSellect:Button?
        when(cellID){
            1 ->bueSellect= btn11
            2 ->bueSellect=btn12
            3 ->bueSellect=btn13
            4 ->bueSellect=btn21
            5 ->bueSellect=btn22
            6 ->bueSellect=btn23
            7 ->bueSellect=btn31
            8 ->bueSellect=btn32
            9 ->bueSellect=btn33
            else->{
                bueSellect= btn11
            }
        }

        play(cellID,bueSellect)
    }
    }
