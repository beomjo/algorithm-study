fun main() {
    val n = readLine()!!.toInt()
    val a = Array(n) { IntArray(n) { 0 } }
    repeat(n) { i -> a[i] = readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
    val d = (0 until n).toMutableList()

    var result = Int.MAX_VALUE

    do {
        var ok = true
        var sum = 0
        for (i in 0 until n - 1) {
            if (a[d[i]][d[i + 1]] == 0) ok = false
            else sum += a[d[i]][d[i + 1]]
        }

        if (ok && a[d[n - 1]][d[0]] != 0) {
            sum += a[d[n - 1]][d[0]]
            if (result > sum) result = sum
        }
    } while (nextPermutation(d))
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