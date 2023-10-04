package com.example.hw1robots

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplication.Robot

private const val TAG = "RobotViewModel"
var turnCount = 0
var uniqueRandomInts = listOf<Int>()

val robots = listOf(
    Robot(R.string.red_robot_mssg, false,
        R.drawable.king_of_detroit_robot_red_large, R.drawable.king_of_detroit_robot_red_small,mutableListOf(),0),

    Robot(R.string.white_robot_mssg, false,
        R.drawable.king_of_detroit_robot_white_large, R.drawable.king_of_detroit_robot_white_small,mutableListOf(),0),
    Robot(R.string.yellow_robot_mssg, false,
        R.drawable.king_of_detroit_robot_yellow_large, R.drawable.king_of_detroit_robot_yellow_small,mutableListOf(),0)
)



class RobotViewModel : ViewModel() {

    var currentTurn = 0
    var start = 0
    init {
        Log.d(TAG, "instance of RobotViewModel created.")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "instance of RobotViewModel about to be destroyed.")
    }

}


fun random_reward(){
    uniqueRandomInts = (1..7).shuffled().take(3)
    uniqueRandomInts = uniqueRandomInts.sorted()

}