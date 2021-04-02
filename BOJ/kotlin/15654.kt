fun main() {
    val bw = System.out.bufferedWriter()
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val c = BooleanArray(n + 1) { false }
    val t = listOf(0) + readLine()!!.split(" ").map { it.toInt() }.sorted()
    val a = IntArray(m) { 0 }

    fun go(depth: Int) {
        if (depth == m) {
            bw.apply {
                write(a.joinToString(" "))
                write("\n")
            }
            return
        }

        for (i in 1..n) {
            if (c[i]) continue

            c[i] = true
            a[depth] = t[i]
            go(depth + 1)
            c[i] = false
        }
    }

    go(0)
    bw.flush()
    bw.close()
}