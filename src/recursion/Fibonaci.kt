package recursion

import java.util.*


fun main() {

    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    scanner.close()
    println(fibonacci(n))

}

fun fibonacci(n: Int): Int {

    if(n == 0 || n == 1)
        return 1
    else
        return fibonacci(n-1)+ fibonacci(n-2)


}