fun main() {
   val n = readLine()!!.toInt()
   val d = Array(n + 1) { LongArray(2) }
   d[1][1] = 1

   for (i in 2..n) {
       for (j in 0..1) {
           d[i][j] = if (j == 0) d[i - 1][0] + d[i - 1][1] else d[i - 1][0]
       }
   }

   println(d[n][0] + d[n][1])
}
