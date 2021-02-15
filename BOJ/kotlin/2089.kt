import java.lang.StringBuilder
import kotlin.math.abs
import kotlin.math.ceil

fun main() {
    var n = readLine()!!.toInt()
    if (n == 0) {
        println(n)
        return
    }
    val sb = StringBuilder()
    while (n != 0) {
        sb.insert(0, abs(n % -2))
        n = ceil(n.toDouble() / -2).toInt()
    }

    println(sb)
}