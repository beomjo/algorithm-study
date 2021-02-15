import kotlin.math.pow

fun main() {
    val (n, b) = readLine()!!.split(" ")
    n.foldIndexed(0) { i, aar, c ->
        val r = if (c in 'A'..'Z') (c - 'A' + 10) else (c - '0')
        aar + (r * b.toDouble().pow(n.length - 1 - i)).toInt()
    }.let(::println)
}

