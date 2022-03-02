package easv.oe.dicecup

import java.io.Serializable
import java.util.List
import kotlin.collections.MutableList

class DiceHistory : Serializable {

    val mHistory = mutableListOf<BERoll>()

    fun addEntry(aRoll: BERoll){
        mHistory.add(aRoll)
    }

    fun getList(): MutableList<BERoll> {
        return mHistory
    }
}

