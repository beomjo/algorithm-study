import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val d = IntArray(n) { 1 } // 길이를 담을 배열
    val v = IntArray(n) { -1 } // 경로를 추적할 인덱스를 담을 배열

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (arr[i] > arr[j] && d[i] < d[j] + 1) {
                d[i] = d[j] + 1
                v[i] = j
            }
        }
    }
    val maxLength = d.maxOf { it }
    var index = d.indexOf(maxLength)
    println(maxLength)

    val stack = Stack<Int>()
    while (index != -1) {
        stack.push(arr[index])
        index = v[index]
    }

    while (!stack.isEmpty()) {
        print("${stack.pop()} ")
    }
}