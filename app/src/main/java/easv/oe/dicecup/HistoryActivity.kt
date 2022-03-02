package easv.oe.dicecup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.io.Serializable

class HistoryActivity : AppCompatActivity(){

    private lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        val history = intent.getStringExtra("HISTORY")
        textView = findViewById(R.id.tvHistoryDisplay)
        textView.text = history.toString()
    }

    private var mHistory = mutableListOf<BERoll>()

    fun addEntry(aRoll: BERoll){
        mHistory.add(aRoll)
    }

    fun getHistory(): String {
        return mHistory.toString()
    }


}