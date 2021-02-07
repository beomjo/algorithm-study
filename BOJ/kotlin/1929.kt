fun main() {
    val (m, n) = readLine()!!.split(' ').map { it.toInt() }
    val check = BooleanArray(n + 1) { false }
    for (i in 2..n) {
        if (!check[i]) {
            if (i > m) println(i)
            var j = 2
            while (i * j <= n) {
                check[i * j] = true
                j++
            }
        }
    }
}