package com.example.hw1robots
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myapplication.Robot

private const val TAG = "MainActivity"
const val EXTRA_ROBOT_ENERGY = "com.bignerdranch.android.robot.current_robot_energy"

class MainActivity : AppCompatActivity() {

    private lateinit var redBotImage: ImageView
    private lateinit var whiteBotImage: ImageView
    private lateinit var yellowBotImage: ImageView
    private lateinit var messageBox: TextView
    private lateinit var reward_button : Button
    private var imagetoint = 0
    private lateinit var robotImages : MutableList<ImageView>

    private val robotViewModel : RobotViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        redBotImage = findViewById(R.id.redRobot)
        whiteBotImage = findViewById(R.id.whiteRobot)
        yellowBotImage = findViewById(R.id.yellowRobot)
        messageBox = findViewById(R.id.messageBox)
        reward_button = findViewById(R.id.purchase_rewards_button)

        robotImages = mutableListOf(redBotImage, whiteBotImage, yellowBotImage)

        redBotImage.setOnClickListener { toggleImage() }
        whiteBotImage.setOnClickListener { toggleImage() }
        yellowBotImage.setOnClickListener { toggleImage() }
        reward_button.setOnClickListener {view : View ->
            val intent = RobotPurchase.newIntent(this, RobotPurchase::class.java)
//            intent.putExtra(EXTRA_ROBOT_ENERGY,)
            intent.putExtra("Whos_turn",imagetoint)
            intent.putExtra(EXTRA_ROBOT_ENERGY, robots[imagetoint].energy)

            intent.putExtra("refresh_reward",1)
            uniqueRandomInts = (1..7).shuffled().take(3)


            startActivity(intent)

        }
        if (turnCount != 0)
        {
            updateMessageBox()
            setRobotsTurn()
            setRobotImages()
        }
    }


    private fun toggleImage() {
        turnCount++
        if(turnCount > 3)
            turnCount = 1

        if (robots[turnCount-1].Purchase_history.size > 0)
        {   var hist = robots[turnCount-1].Purchase_history.joinToString(separator = ", ")

            Toast.makeText(this, "Reward Purchased:" + hist, Toast.LENGTH_SHORT).show()
        }

        updateMessageBox()
        setRobotsTurn()
        setRobotImages()
    }

    private fun updateMessageBox(){
        messageBox.setText(robots[turnCount - 1].messageResource)
    }

    private fun setRobotsTurn(){
        for(robot in robots){robot.myTurn = false}
        robots[turnCount - 1].myTurn = true
    }

    private fun setRobotImages(){
        for(indy in robots.indices){
            if(robots[indy].myTurn){
                robotImages[indy].setImageResource(robots[indy].largeImgRes)
                imagetoint = indy
                robots[imagetoint].energy++
            }else{
                robotImages[indy].setImageResource(robots[indy].smallImgRes)
            }
        }
    }
}