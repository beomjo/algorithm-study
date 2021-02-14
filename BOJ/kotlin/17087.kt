import kotlin.math.abs

fun main() {
    val (n, s) = readLine()!!.split(" ")
    val distances = readLine()!!.split(" ")
        .map { it.toInt() }
        .map { s.toInt() - it }
        .map { abs(it) }
    var result = distances[0]
    (1 until n.toInt()).forEach {
        result = getGCD(result, distances[it])
    }
    println(result)
}

fun getGCD(a: Int, b: Int): Int = if (b == 0) a else getGCD(b, a % b)
