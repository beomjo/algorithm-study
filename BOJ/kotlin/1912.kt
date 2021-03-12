import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val d = IntArray(n)

    d[0] = arr[0]
    for (i in 1 until n) d[i] = max(arr[i] + d[i - 1], arr[i])
    println(d.maxOf { it })
}