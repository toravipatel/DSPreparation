package aug_21_challenge

import java.util.*

fun main() {

    var nums = arrayOf(4122,9928,3477,9942).toIntArray()

    println(minStoneSum(nums,6))
}

fun minStoneSum(piles: IntArray, k: Int): Int {

    var result = 0

    var queue = PriorityQueue<Int>(Collections.reverseOrder())
    piles.forEach {
        queue.add(it)
    }
    var i = 0
    while (i < k){

        var num = Math.ceil(queue.poll().toDouble()/2).toInt()
        queue.add(num)
        i++
    }


    queue.forEach {

        result += it

    }

    return result
}