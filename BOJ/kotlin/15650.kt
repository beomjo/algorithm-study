fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val c = BooleanArray(n + 1) { false }
    val a = IntArray(n + 1) { 0 }

    fun go(at: Int, depth: Int) {
        if (depth == m) {
            println(a.slice(0 until m).joinToString(" "))
        }

        for (i in at..n) {
            if (c[i]) continue

            c[i] = true
            a[depth] = i
            go(i + 1, depth + 1)
            c[i] = false
        }
    }

    go(1, 0)
}

