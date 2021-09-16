package queue

import java.util.*
import javax.print.attribute.standard.Media

fun main() {

    var medianFinder = MedianFinder()
    medianFinder.addNum(1)
    medianFinder.addNum(2)
    println(medianFinder.findMedian())
    medianFinder.addNum(3)
    println(medianFinder.findMedian())

}

class MedianFinder() {

    /** initialize your data structure here. */

    val lower = PriorityQueue<Int>(Collections.reverseOrder())
    var higher = PriorityQueue<Int>()

    fun addNum(num: Int) {

        if(lower.size == 0 || num < lower.peek()){
            lower.add(num)
        }else
            higher.add(num)

        balanceHeap()
    }

    private fun balanceHeap(){
        var lowerSize = lower.size
        var higherSize = higher.size

        if(lowerSize>higherSize){

            if(lowerSize - higherSize >=2) {
                higher.add(lower.poll())
            }
        }
        else{
            if(higherSize-lowerSize >=2)
                lower.add(higher.poll())
        }
    }


    fun findMedian(): Double {

        var lowerSize = lower.size
        var higherSize = higher.size

        if(lowerSize != higherSize){
            if(lowerSize > higherSize)
                return lower.peek().toDouble()
            else
                return higher.peek().toDouble()
        }
        else
            return ((lower.peek() + higher.peek()).toDouble() / 2)

    }

}