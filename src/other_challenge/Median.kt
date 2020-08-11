package other_challenge

import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    val aCount = scan.nextLine().trim().toInt()

    val a = Array<Int>(aCount, { 0 })
    for (aItr in 0 until aCount) {
        val aItem = scan.nextLine().trim().toInt()
        a[aItr] = aItem
    }

    val result = runningMedian(a)

    println(result?.joinToString("\n"))
}

fun runningMedian(a: Array<Int>): Array<Double>? {

   return null
}
