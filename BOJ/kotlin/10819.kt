import kotlin.math.abs
import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.sorted().toMutableList()

    var result = 0
    do {
        var t = 0
        for (i in 0 until a.size - 1) {
            t += abs(a[i] - a[i + 1])
        }
        result = max(result, t)
    } while (nextPermutation(a))
    println(result)
}

fun nextPermutation(a: MutableList<Int>): Boolean {
    val lastIndex = a.size - 1
    var i = (1..lastIndex).findLast { a[it] > a[it - 1] } ?: return false
    var j = (i..lastIndex).findLast { a[it] > a[i - 1] } ?: return false
    a.swap(i - 1, j)
    j = lastIndex
    while (i < j) a.swap(i++, j--)
    return true
}

fun <T> MutableList<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}