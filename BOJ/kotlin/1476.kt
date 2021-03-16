import java.util.*
import kotlin.system.exitProcess

fun main() = with(Scanner(System.`in`)) {
    val e = nextInt() - 1
    val m = nextInt() - 1
    val s = nextInt() - 1

    var i = 0
    while (true) {
        if (i % 15 == e && i % 28 == m && i % 19 == s) {
            println(i + 1)
            exitProcess(0)
        }
        i++
    }
}