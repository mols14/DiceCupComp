package easv.oe.dicecup

import java.util.*

class BERoll(
    val time: Date,
    val eyes: IntArray) {
    override fun toString(): String {
        return "${time.hours}:${time.minutes}. ${eyes[0]} - ${eyes[1]}\n"
    }
}