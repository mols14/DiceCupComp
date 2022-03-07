package easv.oe.dicecup

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import java.util.*
import android.content.ContentValues.TAG
import android.content.Intent
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var round = 0
    var dieNo = 2

    // mapping from 1..6 to drawables, the first index is unused
    private val diceId = intArrayOf(0, R.drawable.dice1,
                               R.drawable.dice2,
                               R.drawable.dice3,
                               R.drawable.dice4,
                               R.drawable.dice5,
                               R.drawable.dice6)

    private val mRandomGenerator = Random()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "OnCreate")

        val orientation = this.getResources().getConfiguration().orientation
        val message = if (orientation == Configuration.ORIENTATION_PORTRAIT) "Portrait" else "Landscape"
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()

        //if (savedInstanceState != null)
        //{
          //    Log.d(TAG, "saved state NOT null")
            //  val history = savedInstanceState.getSerializable("HISTORY") as DiceHistory
              //kopier...
              //if (mHistory.size > 0)
              //{
              //    updateDicesWith(mHistory[mHistory.size - 1])
              //}
        //}

        showDices(intArrayOf(2,3))
    }

     fun onClickRoll(v: View){
         round++
        val p = mutableListOf<Int>()
        for (i in 1..dieNo){
            val eDice = mRandomGenerator.nextInt(6)+1
            p.add(eDice)
        }
        val aRoll = BERoll(round, Date(), p.toIntArray())
        History.addEntry(aRoll)
        showDices(p.toIntArray())
        Log.d(TAG, "Roll")
         val tvHistory = findViewById<TextView>(R.id.tvHistory)
         tvHistory.text = p.toString()
    }

    //override fun onSaveInstanceState(outState: Bundle) {
    //   super.onSaveInstanceState(outState)
    //    outState.putSerializable("HISTORY", mHistory)
    // }

    fun showDices(eyes: IntArray) {
        val layoutDices = findViewById<LinearLayout>(R.id.layoutDices)
        layoutDices.removeAllViews()
        for (idx in 0..eyes.size - 1) {
            val imageView = ImageView(this)
            imageView.maxWidth = 80
            imageView.adjustViewBounds = true
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            lp.setMargins(10, 10, 10, 10)
            imageView.layoutParams = lp
            imageView.setImageResource(diceId[eyes[idx]])
            layoutDices.addView(imageView)
        }
    }

    fun onClickRemoveDie(view: View) {
        if (dieNo == 1) return
        dieNo--
        showDices((1..dieNo).toList().toIntArray())
    }

    fun onClickAddDie(view: View) {
        if (dieNo == 6) return
        dieNo++
        showDices((1..dieNo).toList().toIntArray())}

    fun onClickHistory(view: View) {
        val intent = Intent(this, HistoryActivity::class.java)
        startActivity(intent)
    }
}
