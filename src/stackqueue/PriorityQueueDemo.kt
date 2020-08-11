package stackqueue

import java.util.*

fun main() {

    val priorityQueue = PriorityQueue<Int>()

    priorityQueue.add(5)
    priorityQueue.add(8)
    priorityQueue.add(1)
    priorityQueue.add(4)

    priorityQueue.add(0)

    priorityQueue.forEach {

        println(it)
    }

    println("---------")



    while (!priorityQueue.isEmpty()){
        println(priorityQueue.remove())
    }





}