fun main() {
    val d = IntArray(1000001) { 0 }
    val n = readLine()!!.toInt()

    d[1] = 0
    (2..n).forEach { i ->
        d[i] = d[i - 1] + 1

        if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
            d[i] = d[i / 2] + 1
        }

        if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
            d[i] = d[i / 3] + 1
        }
    }

    println(d[n])
}