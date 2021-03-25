fun main() {
    repeat(readLine()!!.toInt()) {
        var (m, n, x, y) = readLine()!!.split(" ").map { it.toInt() }
        x -= 1
        y -= 1

        var isFind = false
        for (i in x..(m * n) step m) {
            if (i % m == x && i % n == y) {
                isFind = true
                println(i + 1)
                break
            }
        }
        if (!isFind) println(-1)
    }
}
