
import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val a = Array(n) { CharArray(n) }
    var ans = 0

    for (i in 0 until n) a[i] = readLine()!!.toCharArray()

    fun swap(startI: Int, startJ: Int, endI: Int, endJ: Int) {
        val temp = a[startI][startJ]
        a[startI][startJ] = a[endI][endJ]
        a[endI][endJ] = temp
    }

    fun check() {
        for (i in 0 until n) {
            var count = 1
            for (j in 0 until n - 1) {
                if (a[i][j] == a[i][j + 1]) {
                    count++
                } else {
                    ans = max(ans, count)
                    count = 1
                }
            }
            ans = max(ans, count)
        }

        for (j in 0 until n) {
            var count = 1
            for (i in 0 until n - 1) {
                if (a[i][j] == a[i + 1][j]) {
                    count++
                } else {
                    ans = max(ans, count)
                    count = 1
                }
            }
            ans = max(ans, count)
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (j + 1 < n) {
                swap(i, j, i, j + 1)
                check()
                swap(i, j, i, j + 1)
            }

            if (i + 1 < n) {
                swap(i, j, i + 1, j)
                check()
                swap(i, j, i + 1, j)
            }
        }
    }

    println(ans)
}