package greedy_problem

import java.util.*

// Complete the maxMin function below.
fun maxMin(k: Int, arr: Array<Int>): Int {

    arr.sort()

    var maxMinSum = Int.MAX_VALUE

    for(i in 0 until (arr.size-k+1)){

        var currentSum = arr[i+k-1] - arr[i]
        if(currentSum < maxMinSum)
        {
            maxMinSum = currentSum
        }
    }


    return maxMinSum

}

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val k = scan.nextLine().trim().toInt()

    val arr = Array<Int>(n, { 0 })
    for (i in 0 until n) {
        val arrItem = scan.nextLine().trim().toInt()
        arr[i] = arrItem
    }

    val result = maxMin(k, arr)

    println(result)

}