package com.example.myapplication

data class Robot(
    val messageResource : Int,
    var myTurn : Boolean,
    val largeImgRes : Int,
    val smallImgRes : Int,
    var Purchase_history : MutableList<String> ,
    var energy : Int
)