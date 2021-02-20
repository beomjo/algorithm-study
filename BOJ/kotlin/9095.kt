fun main() {
    val d = IntArray(11) { 0 }
    d[0] = 1
    d[1] = 1
    d[2] = 2
    for (i in 3..10) d[i] = d[i - 1] + d[i - 2] + d[i - 3]
    repeat(readLine()!!.toInt()) { println(d[readLine()!!.toInt()]) }
}
