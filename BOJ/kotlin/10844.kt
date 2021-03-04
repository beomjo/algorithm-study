fun main() {
    val n = readLine()!!.toInt()
    val d = Array(n + 1) { LongArray(10) }
    val mod = 1_000_000_000L

    for (i in 1..9) d[1][i] = 1
    for (i in 2..n) {
        for (j in 0..9) {
            d[i][j] = when (j) {
                0 -> (d[i - 1][j + 1]) % mod
                9 -> (d[i - 1][j - 1]) % mod
                else -> (d[i - 1][j - 1] + d[i - 1][j + 1]) % mod
            }
        }
    }
    (0..9).sumOf { d[n][it] }.let { it % mod }.let(::println)
}