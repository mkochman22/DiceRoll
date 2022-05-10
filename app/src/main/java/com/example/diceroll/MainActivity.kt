package com.example.diceroll
/*Mary Kochmanski
CIS 211 Thursdays 5:00-7:45*/

/*IMPORT STATEMENTS*/
import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*When button is clicked, rollDice function is called */
        val rollButton: Button = findViewById(R.id.buttonRoll)
        rollButton.setOnClickListener {
            rollDice()

        }


    }

    /*Roll dice, generates a random number between 1-6, prints out that number, and generates an image based on the number
    If a two is rolled, a different image is generated, text is displayed, and a sound plays
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.numberRolled)
        resultTextView.text = diceRoll.toString()

        if(diceRoll == 2){
            val luckynumber: TextView = findViewById(R.id.luckyNumber)
            luckynumber.visibility = View.VISIBLE

            val image: ImageView = findViewById(R.id.profile)
            image.setImageResource(R.drawable.beluga)
            image.visibility = View.VISIBLE

            var mediaPlayer = MediaPlayer.create(this, R.raw.yahaha)
            mediaPlayer.start()
        }else{
            val luckynumber: TextView = findViewById(R.id.luckyNumber)
            luckynumber.visibility = View.INVISIBLE

            val image: ImageView = findViewById(R.id.profile)
            image.setImageResource(R.drawable.peppa)
            image.visibility = View.VISIBLE
        }
    }

}
/*Generates random number between 1 and numSlides*/
class Dice(private val numSides: Int){
    fun roll(): Int {
        return (1..numSides).random()
    }
}