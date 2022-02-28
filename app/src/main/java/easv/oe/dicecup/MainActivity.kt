package easv.oe.dicecup

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var dieNo = 2;
    var mHistory = DiceHistory()
//    var diceDrawer = DrawDice(mHistory)


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
        btnRoll.setOnClickListener { v -> onClickRoll() }
        Log.d(TAG, "OnCreate")

        val orientation = this.getResources().getConfiguration().orientation
        val message = if (orientation == Configuration.ORIENTATION_PORTRAIT) "Portrait" else "Landscape"
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()

        if (savedInstanceState != null)
        {
              Log.d(TAG, "saved state NOT null")
              val history = savedInstanceState.getSerializable("HISTORY") as DiceHistory
              mHistory = history
              updateHistory()
//              if (mHistory.size > 0)
//              {
//                  updateDicesWith(mHistory[mHistory.size - 1])
//              }
        }
    }

    private fun onClickRoll(){
        val e1 = mRandomGenerator.nextInt(6) + 1
        val e2 = mRandomGenerator.nextInt(6) + 1
        val p = String
        updateHistory()
        mHistory.addEntry(p)

        updateDicesWith(p)
        if (mHistory.size > 5) {
            mHistory.remove()
            updateHistory()
        }
        Log.d(TAG, "Roll")
    }

    private fun onClickClear() {
        Log.d(TAG, "Clear")
        mHistory.clear()
        updateHistory()
    }

    // ensures that the history text aligns the history object
    private fun updateHistory() {
        var s = ""
        mHistory.forEach { p ->  val e1 = p.first; val e2 = p.second; s += "$e1 - $e2 \n" }
        tvHistory.text = s
    }

    private fun updateDicesWith(p: String) {
        imgDice1.setImageResource( diceId[p.first] )
        imgDice2.setImageResource( diceId[p.second] )
    }

    //<editor-fold desc="onSaveInstanceState">
    override fun onSaveInstanceState(outState: Bundle) {
       super.onSaveInstanceState(outState)
        outState.putSerializable("HISTORY", mHistory.toTypedArray())
     }

    fun btnAddDie(view: View) {
        val imageView = ImageView(this)
        imageView.layoutParams = layoutDices.layoutParams
        var resId = R.drawable.hex
        imageView.setImageResource(resId)
        when (doubleCount) {
            2 -> dis2.addView(imageView)
        }
    }

    fun btnRemoveDie(view: View) {

    }

}
