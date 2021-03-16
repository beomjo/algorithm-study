import kotlin.system.exitProcess

fun main() {
    val a = (0 until 9).map { readLine()!!.toInt() }.toList().sorted()
    val sum = a.sum()

    for (i in 0 until 9) {
        for (j in i + 1 until 9) {
            if ((sum - a[i] - a[j]) == 100) {
                (0 until 9)
                    .filter { it != i && it != j }
                    .map { a[it] }
                    .forEach(::println)
                exitProcess(0);
            }
        }
    }
}