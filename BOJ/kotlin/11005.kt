fun main() {
    var (n, b) = readLine()!!.split(" ").map { it.toInt() }
    var answer = ""
    while (n > 0) {
        val rest = n % b
        answer += when (rest) {
            in 0..9 -> rest
            else -> ('A' + (rest - 10))
        }.toString()
        n /= b
    }
    println(answer.reversed())
}