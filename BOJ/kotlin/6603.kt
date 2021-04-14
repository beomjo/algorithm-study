lateinit var a: MutableList<Int>
lateinit var c: MutableList<Boolean>
var n: Int = 0

fun dfs(start: Int, depth: Int) {
    if (depth == 6) {
        for (i in 0 until n) {
            if (c[i]) print("${a[i]} ")
        }
        println()
        return
    }

    for (i in start until n) {
        c[i] = true
        dfs(i + 1, depth + 1)
        c[i] = false
    }
}

fun main() {
    while (true) {
        val input = readLine()!!.split(" ").map { it.toInt() }
        n = input[0]
        if (n == 0) break

        a = input.subList(1, input.size).toMutableList()
        c = BooleanArray(n) { false }.toMutableList()

        dfs(0, 0)
        println()
    }
}