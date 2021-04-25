import kotlin.math.max

val a: MutableList<Int> = mutableListOf()
val p: MutableList<Int> = mutableListOf()
var n: Int = 0
var result: Int = 0

fun go(day: Int, total: Int) {
    if (day == n) {
        result = max(result, total)
        return
    }

    go(day + 1, total)
    if (day + a[day] <= n) {
        go(day + a[day], total + p[day])
    }
}

fun main() {
    n = readLine()!!.toInt()
    repeat(n) {
        val (day, price) = readLine()!!.split(" ").map { it.toInt() }
        a.add(day)
        p.add(price)
    }
    go(0, 0)
    println(result)
}
