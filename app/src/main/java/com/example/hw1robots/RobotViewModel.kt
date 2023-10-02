package com.example.hw1robots

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplication.Robot

private const val TAG = "RobotViewModel"
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
//    internal val robots = listOf(
//        Robot(R.string.red_turn, false,
//            R.drawable.king_of_detroit_robot_red_large, R.drawable.king_of_detroit_robot_red_small),
//        Robot(R.string.white_turn, false,
//            R.drawable.king_of_detroit_robot_white_large, R.drawable.king_of_detroit_robot_white_small),
//        Robot(R.string.yellow_turn, false,
//            R.drawable.king_of_detroit_robot_yellow_large, R.drawable.king_of_detroit_robot_yellow_small)
//    )

}
