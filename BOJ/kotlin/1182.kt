fun main() {
    val (n, s) = readLine()!!.split(" ").map { it.toInt() }
    val a = readLine()!!.split(" ").map { it.toInt() }

    var result = 0
    for (i in 1 until (1 shl n)) {
        var sum = 0
        for (j in 0 until n) {
            if (getBit(i, j)) sum += a[j]
        }
        if (sum == s) result++
    }
    println(result)
}

fun getBit(num: Int, i: Int) = (num and (1 shl i)) != 0