import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val d = IntArray(n) { 1 }

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (arr[i] > arr[j]) {
                d[i] = max(d[i], d[j] + 1)
            }
        }
    }

    println(d.maxOf { it })
}