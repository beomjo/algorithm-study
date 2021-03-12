import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val d = IntArray(n + 1)

    for (i in 1..n) {
        d[i] = i
        var j = 1
        while (j * j <= i) {
            d[i] = min(d[i], d[i - j * j] + 1)
            j++
        }
    }
    println(d[n])
}