val d = Array(100_001) { LongArray(4) { 0 } }
const val mod = 1_000_000_009L

fun main() {
    d[1] = longArrayOf(0, 1, 0, 0)
    d[2] = longArrayOf(0, 0, 1, 0)
    d[3] = longArrayOf(0, 1, 1, 1)


    repeat(readLine()!!.toInt()) {
        val i = readLine()!!.toInt()
        println((go(i, 1) + go(i, 2) + go(i, 3)) % mod)
    }
}

fun go(i: Int, num: Int): Long {
    if (i <= 3 || d[i][num] > 0) {
        return d[i][num]
    }

    d[i][2] = (go(i - 2, 1) + go(i - 2, 3)) % mod
    d[i][1] = (go(i - 1, 2) + go(i - 1, 3)) % mod
    d[i][3] = (go(i - 3, 1) + go(i - 3, 2)) % mod

    return d[i][num] % mod
}
