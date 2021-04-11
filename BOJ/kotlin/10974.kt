import java.lang.StringBuilder

fun main() {
    val n = readLine()!!.toInt()
    val a = (1..n).toMutableList()
    val sb = StringBuilder()

    do {
        sb.append(a.joinToString(" ")).append("\n")
    } while (nextPermutation(a))
    println(sb)
}

fun nextPermutation(a: MutableList<Int>): Boolean {
    val lastIndex = a.size - 1
    var i = (lastIndex downTo 1).find { a[it] > a[it - 1] } ?: return false
    var j = (lastIndex downTo i).find { a[it] > a[i - 1] } ?: return false
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