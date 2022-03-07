package easv.oe.dicecup

import android.content.Intent
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
        textView = findViewById(R.id.tvHistoryDisplay)
        textView.text = History.getHistory()
    }

    fun onClickClear(view: View) {
        History.clear()
        textView = findViewById(R.id.tvHistoryDisplay)
        textView.text = History.getHistory()
    }

    fun onClickBack(view: View) {
        finish()
    }
}