package easv.oe.dicecup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.Serializable

class HistoryActivity : AppCompatActivity(), Serializable {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
    }

    val mHistory = mutableListOf<BERoll>()

    fun addEntry(aRoll: BERoll){
        mHistory.add(aRoll)
    }

    fun getList(): MutableList<BERoll> {
        return mHistory
    }

}