import kotlin.math.max

fun main() {
    val (row, column) = readLine()!!.split(" ").map { it.toInt() }
    val a = Array(row) { IntArray(column) }
    for (i in 0 until row) {
        val st = readLine()!!
        for (j in 0 until column) {
            a[i][j] = Character.getNumericValue(st[j])
        }
    }

    var result = 0

    for (i in 0 until (1 shl row * column)) {
        var sum = 0
        for (r in 0 until row) {
            var rowSum = 0
            for (c in 0 until column) {
                val colIndex = r * column + c
                if (i and (1 shl colIndex) == 0) {
                    rowSum = rowSum * 10 + a[r][c]
                } else {
                    sum += rowSum
                    rowSum = 0
                }
            }
            sum += rowSum
        }
        for (c in 0 until column) {
            var colSum = 0
            for (r in 0 until row) {
                val rowIndex = c + r * column
                if (i and (1 shl rowIndex) != 0) {
                    colSum = colSum * 10 + a[r][c]
                } else {
                    sum += colSum
                    colSum = 0
                }
            }
            sum += colSum
        }
        result = max(result, sum)
    }
    println(result)
}