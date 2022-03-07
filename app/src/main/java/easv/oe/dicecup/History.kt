package easv.oe.dicecup

object History {
    private var mHistory = mutableListOf<BERoll>()

    fun addEntry(aRoll: BERoll){
        mHistory.add(aRoll)
    }

    fun getHistory(): String {
        return mHistory.toString()
    }

    fun clear() {
        mHistory.clear()
    }
}