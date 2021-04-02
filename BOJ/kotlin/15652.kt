fun main() {
    val bw = System.out.bufferedWriter();
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val a = IntArray(m) { 0 }

    fun go(at: Int, depth: Int) {
        if (depth == m) {
            bw.apply {
                write(a.joinToString(" "))
                write("\n")
            }
            return
        }

        for (i in at..n) {
            a[depth] = i
            go(i, depth + 1)
        }
    }

    go(1, 0)
    bw.flush()
    bw.close()
}