package array

import java.util.*

// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

fun main() {

    println(largestSumAfterKNegations(intArrayOf(-8, 3, -5, -3, -5, -2), 6))
}

fun largestSumAfterKNegations(nums: IntArray, k: Int): Int {

    nums.sort()
    var currentSum = 0
    var changeCounter = 0

    var priorityQueue = PriorityQueue<Int>()
    nums.forEach { priorityQueue.add(it) }

    while (changeCounter < k) {

        if(priorityQueue.last() == 0){
            break
        }

        priorityQueue.add(-priorityQueue.poll())
        changeCounter++
    }

    priorityQueue.forEach {
        currentSum += it
    }
    return currentSum
}