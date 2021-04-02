fun main() {
    val bw = System.out.bufferedWriter()
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
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
            a[depth] = t[i]
            go(depth + 1)
        }
    }

    go(0)
    bw.flush()
    bw.close()
}