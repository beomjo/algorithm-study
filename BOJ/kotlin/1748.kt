
fun main() {
    val n = readLine()!!.toInt()
    var answer = 0
    var len = 1
    var start = 1
    while (start <= n) {
        var end = start * 10 - 1
        if (end > n) end = n
        answer += len * (end - start + 1)
        len++
        start *= 10
    }
    println(answer)
}
