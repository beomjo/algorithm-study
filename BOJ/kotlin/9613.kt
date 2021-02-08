fun main() {
    repeat(readLine()!!.toInt()) {
        val arr = readLine()!!.split(" ").map { it.toLong() }
        val sum = (1 until arr.size).map { i ->
            (1 until i).map { j ->
                getGCD(arr[i], arr[j])
            }.sum()
        }.sum()
        println(sum)
    }

}

fun getGCD(a: Long, b: Long): Long = if (b == 0L) a else getGCD(b, a % b)