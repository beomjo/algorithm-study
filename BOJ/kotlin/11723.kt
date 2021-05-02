
import java.lang.IllegalStateException

fun main() {
    val sb = StringBuilder()
    val n = readLine()!!.toInt()
    var bit = 0
    repeat(n) {
        val input = readLine()!!.split(" ")
        val op = input[0]
        val index = if (op !in listOf("all", "empty")) input[1].toInt() - 1 else -1
        bit = when (op) {
            "add" -> setBit(bit, index)
            "remove" -> clearBit(bit, index)
            "toggle" -> toggleBit(bit, index)
            "check" -> {
                sb.append(if (getBit(bit, index)) 1 else 0).append("\n")
                bit
            }
            "all" -> -1
            "empty" -> 0
            else -> throw IllegalStateException()
        }
    }
    println(sb)
}

fun getBit(num: Int, i: Int) = (num and (1 shl i)) != 0
fun setBit(num: Int, i: Int) = num or (1 shl i)
fun clearBit(num: Int, i: Int) = num and (1 shl i).inv()
fun toggleBit(num: Int, i: Int) = num xor (1 shl i)

