import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val l = nextInt()
    val c = nextInt()
    val str = Array(c) { next()[0] }.sortedArray()

    val used = Array(c) { false }

    fun find(i: Int, n: Int) {
        used[i] = true

        if (n < l) {
            for (x in i + 1 until c) find(x, n + 1)
        } else {
            val pass = (0 until c)
                .filter { used[it] }
                .map { str[it] }
                .joinToString("")

            if (pass.count { it in "aeiou" } >= 1 &&
                pass.count { it !in "aeiou" } >= 2) {
                println(pass)
            }
        }

        used[i] = false
    }

    for (i in 0 until c) find(i, 1)
}