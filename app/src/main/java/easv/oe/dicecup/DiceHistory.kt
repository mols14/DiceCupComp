package easv.oe.dicecup

import java.io.Serializable
import java.util.List
import kotlin.collections.MutableList

class DiceHistory : Serializable, List<> {

    val mHistory = mutableListOf<String>("0","0","0","0","0","0")
    private var doubleCount = 0

    fun addEntry(str: String){
        mHistory.add(0, str)
    }

    fun getList(): MutableList<String> {
        return mHistory
    }
    fun remove() {
        mHistory.removeAt(0)
    }

}