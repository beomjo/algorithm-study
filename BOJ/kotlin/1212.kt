val octToBin: List<String> = listOf("000", "001", "010", "011", "100", "101", "110", "111")
fun main() {
    readLine()!!.toCharArray().let { arr ->
        if (arr.size == 1 && arr[0] == '0') "0"
        else arr.joinToString("") { c -> octToBin[c - '0'] }
            .let { it.substring(it.indexOf('1')) }
    }.let(::println)
}
