fun main() {
    val n = readLine()!!.toInt()
    val d = IntArray(n + 1) { 0 }
    d[1] = 1
    d[2] = 2
    for (i in 3..n) d[i] = (d[i - 1] + d[i - 2]) % 10007
    println(d[n])
}
