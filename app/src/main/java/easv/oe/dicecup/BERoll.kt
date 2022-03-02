package easv.oe.dicecup

import java.util.*

class BERoll(
    val time: Date,
    val eyes: IntArray) {
    override fun toString(): String {
        var e = mutableListOf<String>()
        for (eye in eyes) {
            e.add("$eye ")
        }
        return "${time.hours}:${time.minutes}. ${e}\n\n"
    }
}