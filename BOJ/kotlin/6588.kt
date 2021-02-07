import java.lang.StringBuilder

fun main() {
    val sb = StringBuilder()
    val end = 1000001
    val check = BooleanArray(end + 1) { false }
    for (i in 2..end) {
        if (!check[i]) {
            var j = 2
            while (i * j <= end) {
                check[i * j] = true
                j++
            }
        }
    }

    while (true) {
        val n = readLine()!!.toInt()
        if (n == 0) break
        for (i in 2..n / 2) {
            val a = i
            val b = n - a
            if (!check[a] && !check[b]) {
                sb.append("$n = $a + $b\n")
                break
            }
        }
    }
    println(sb)
}
