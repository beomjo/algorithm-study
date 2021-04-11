fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    if (isNextPermutation(a)) {
        println(a.joinToString(" "))
    } else {
        println(-1)
    }
}

fun isNextPermutation(a: MutableList<Int>): Boolean {
    var i = (1 until a.size).findLast { a[it] > a[it - 1] } ?: return false
    var j = (i until a.size).findLast { a[it] > a[i - 1] } ?: return false
    a.swap(i - 1, j)
    j = a.size - 1
    while (i < j) a.swap(i++, j--)
    return true
}

fun <T> MutableList<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}