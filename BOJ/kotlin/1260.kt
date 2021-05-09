
import java.io.*
import java.util.*

var n = 0
var m = 0
lateinit var arr: Array<IntArray>
lateinit var visited: BooleanArray
var start = 0
var bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val temp = readLine()!!.split(" ").toTypedArray()
    n = temp[0].toInt()
    m = temp[1].toInt()
    start = temp[2].toInt()
    arr = Array(n + 1) { IntArray(n + 1) }
    for (i in 0 until m) {
        val temp2 = readLine()!!.split(" ").toTypedArray()
        val a = temp2[0].toInt()
        val b = temp2[1].toInt()
        arr[a][b] = 1
        arr[b][a] = 1
    }
    visited = BooleanArray(n + 1)
    dfs(start)
    bw.newLine()
    visited = BooleanArray(n + 1)
    bfs(start)
    bw.flush()
    bw.close()
}

fun dfs(k: Int) {
    visited[k] = true
    bw.write("$k ")
    for (i in 1..n) {
        if (arr[k][i] == 1 && !visited[i]) dfs(i)
    }
}

fun bfs(k: Int) {
    val q: Queue<Int> = LinkedList()
    visited[k] = true
    bw.write("$k ")
    q.offer(k)
    while (!q.isEmpty()) {
        val a = q.poll()
        for (i in 1..n) {
            val b = arr[a][i]
            if (b != 0 && !visited[i]) {
                q.offer(i)
                visited[i] = true
                bw.write("$i ")
            }
        }
    }
}