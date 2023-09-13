package com.example.hw1robots

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {


    private  lateinit var redImg:ImageView
    private  lateinit var whiteImg:ImageView
    private  lateinit var yellowImg:ImageView
    private  lateinit var clockwiseButton:ImageButton
    private  lateinit var counterButton:ImageButton

    var turnCount = 0
    var clockwise = 0
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        redImg = findViewById(R.id.redRobot)
        whiteImg = findViewById(R.id.whiteRobot)
        yellowImg = findViewById(R.id.yellowRobot)

        clockwiseButton = findViewById(R.id.imageButton)
        counterButton = findViewById(R.id.imageButton2)

        clockwiseButton.setOnClickListener { view: View -> toggleButton() }
        counterButton.setOnClickListener { view: View -> toggleButton2() }


        redImg.setOnClickListener{view: View -> toggleImage()}
        whiteImg.setOnClickListener{view: View -> toggleImage()}
        yellowImg.setOnClickListener{view: View -> toggleImage()}

    }


    private fun toggleImage(){
        turnCount++
        if (turnCount > 2){
            turnCount = 0
        }
        if (turnCount == 1){// red is large
            redImg.setImageResource(R.drawable.king_of_detroit_robot_red_large)
            whiteImg.setImageResource(R.drawable.king_of_detroit_robot_white_small)
            yellowImg.setImageResource(R.drawable.king_of_detroit_robot_yellow_small)
        }else if (turnCount == 2){
            redImg.setImageResource(R.drawable.king_of_detroit_robot_red_small )
            whiteImg.setImageResource(R.drawable.king_of_detroit_robot_white_large)
            yellowImg.setImageResource(R.drawable.king_of_detroit_robot_yellow_small)
        }else{
            redImg.setImageResource(R.drawable.king_of_detroit_robot_red_small)
            whiteImg.setImageResource(R.drawable.king_of_detroit_robot_white_small)
            yellowImg.setImageResource(R.drawable.king_of_detroit_robot_yellow_large)
        }

    }

    private fun toggleButton(){
        clockwise++
        if (clockwise > 2){
            clockwise = 0
        }
        if (clockwise == 1){// red is large
            redImg.setImageResource(R.drawable.king_of_detroit_robot_red_large)
            whiteImg.setImageResource(R.drawable.king_of_detroit_robot_white_small)
            yellowImg.setImageResource(R.drawable.king_of_detroit_robot_yellow_small)
        }else if (clockwise == 0){
            redImg.setImageResource(R.drawable.king_of_detroit_robot_red_small )
            whiteImg.setImageResource(R.drawable.king_of_detroit_robot_white_large)
            yellowImg.setImageResource(R.drawable.king_of_detroit_robot_yellow_small)
        }else{
            redImg.setImageResource(R.drawable.king_of_detroit_robot_red_small)
            whiteImg.setImageResource(R.drawable.king_of_detroit_robot_white_small)
            yellowImg.setImageResource(R.drawable.king_of_detroit_robot_yellow_large)
        }

    }
    private fun toggleButton2(){
        clockwise++
        if (clockwise > 2){
            clockwise = 0
        }
        if (clockwise == 1){// red is large
            redImg.setImageResource(R.drawable.king_of_detroit_robot_red_large)
            whiteImg.setImageResource(R.drawable.king_of_detroit_robot_white_small)
            yellowImg.setImageResource(R.drawable.king_of_detroit_robot_yellow_small)
        }else if (clockwise == 2){
            redImg.setImageResource(R.drawable.king_of_detroit_robot_red_small )
            whiteImg.setImageResource(R.drawable.king_of_detroit_robot_white_large)
            yellowImg.setImageResource(R.drawable.king_of_detroit_robot_yellow_small)
        }else{
            redImg.setImageResource(R.drawable.king_of_detroit_robot_red_small)
            whiteImg.setImageResource(R.drawable.king_of_detroit_robot_white_small)
            yellowImg.setImageResource(R.drawable.king_of_detroit_robot_yellow_large)
        }

    }

}