import java.util.*

val maxValue = 1000 * 10000
val d = IntArray(1001) { maxValue }
val p = IntArray(1001) { 0 }

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    for (i in 1..n) p[i] = sc.nextInt()
    println(go(n))
}

fun go(i: Int): Int {
    if (i == 0) return 0
    if (d[i] != maxValue) return d[i]
    for (j in 1..i) d[i] = kotlin.math.min(d[i], go(i - j) + p[j])
    return d[i];
}

