import java.util.*
import kotlin.math.abs

var map = Array(21) { IntArray(21) }
var visited = BooleanArray(21)
var n = 0
var ans:Int = Int.MAX_VALUE
fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()

    for (i in 1..n) {
        for (j in 1..n) {
            map[i][j] = sc.nextInt()
        }
    }
    dfs(0, 0)
    println(ans)

}

fun dfs(v: Int, len: Int) {
    if (n / 2 == len) {
        divideTeam()
    } else {
        for (i in v + 1..n) {
            if (!visited[i]) {
                visited[i] = true
                dfs(i, len + 1)
            }
        }
    }
    visited[v] = false
}

fun divideTeam() {
    val a = IntArray(n / 2 + 1)
    val b = IntArray(n / 2 + 1)
    var ai = 1
    var bi = 1
    for (i in 1..n) {
        if (visited[i]) {
            a[ai++] = i
        } else {
            b[bi++] = i
        }
    }
    val aStat = getStat(a)
    val bStat = getStat(b)
    val diff = abs(aStat - bStat)
    if (ans > diff) {
        ans = diff
    }
}

fun getStat(array: IntArray): Int {
    var result = 0
    val len = n / 2
    for (i in 1..len) {
        for (j in i + 1..len) {
            result += map[array[i]][array[j]]
            result += map[array[j]][array[i]]
        }
    }
    return result
}