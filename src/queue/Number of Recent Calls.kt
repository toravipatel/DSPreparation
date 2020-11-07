package queue

import java.util.*

fun main() {

}



class RecentCounter() {

    var recentCounterQueue:Queue<Int> = LinkedList<Int>()

    fun ping(t: Int): Int {

        recentCounterQueue.add(t)
        while (recentCounterQueue.peek() < t - 3000){

            recentCounterQueue.poll()
        }


        return recentCounterQueue.size
    }

}