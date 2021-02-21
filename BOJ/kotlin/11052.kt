import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val d = IntArray(n + 1) { 0 }
    val p = "0 ${readLine()!!}".split(" ").map { it.toInt() }
    for (i in 1..n)
        for (j in 1..i) d[i] = max(d[i], d[i - j] + p[j])
    println(d[n])
}
