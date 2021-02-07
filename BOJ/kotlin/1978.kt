fun main() {
    readLine()
    println(readLine()!!.split(' ').map(String::toInt).filter(::isPrime).size)
}

private fun isPrime(n: Int) = n != 1 && !(2 until n).any { n % it == 0 }

