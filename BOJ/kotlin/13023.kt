import java.util.*
import kotlin.collections.ArrayList

var n = 0
var m = 0
var list: ArrayList<ArrayList<Int>> = ArrayList()
lateinit var visit: BooleanArray

fun dfs(now: Int, depth: Int): Boolean {
    if (depth == 5) return true
    visit[now] = true
    for (i in list[now].indices) {
        val next = list[now][i]
        if (visit[next]) continue
        if (dfs(next, depth + 1)) return true
    }
    visit[now] = false
    return false
}

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()
    for (i in 0 until n) list.add(ArrayList())
    for (i in 0 until m) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        list[a].add(b)
        list[b].add(a)
    }
    for (i in 0 until n) {
        visit = BooleanArray(n)
        if (dfs(i, 1)) {
            println("1")
            return
        }
    }
    println("0")
}