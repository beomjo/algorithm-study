val c = BooleanArray(9) { false }
val a = IntArray(9) { 0 }

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    go(0, n, m)
}

fun go(index: Int, n: Int, m: Int) {
    if (index == m) {
        for (i in 0 until m) {
            print("${a[i]} ")
        }
        println()
    }

    for (i in 1..n) {
        if (c[i]) continue

        c[i] = true
        a[index] = i
        go(index + 1, n, m)
        c[i] = false
    }
}
