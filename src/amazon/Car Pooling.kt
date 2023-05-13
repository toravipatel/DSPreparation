package amazon

import java.util.*
import kotlin.collections.ArrayList

//https://leetcode.com/problems/car-pooling/
fun main() {


    var tripList = ArrayList<IntArray>()
    tripList.add(arrayOf(9,0,1).toIntArray())
    tripList.add(arrayOf(3,3,7).toIntArray())
    /*tripList.add(arrayOf(1,3,6).toIntArray())
    tripList.add(arrayOf(8,4,6).toIntArray())
    tripList.add(arrayOf(4,4,8).toIntArray())*/

    println(carPooling(tripList.toTypedArray() ,4))

}

fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {

    if(trips.size == 0)
        return true

    if(trips[0][0] > capacity)
        return false

    var capacityAllocator = PriorityQueue<IntArray>(kotlin.Comparator { o1, o2 ->
        o1[2]- o2[2]
    })

    Arrays.sort(trips, kotlin.Comparator { o1, o2 ->
        o1[1] - o2[1]
    })

    var currentCapacity = 0

    capacityAllocator.add(trips[0])
    currentCapacity += trips[0][0]
    var i = 1
    while(i < trips.size)
    {

        if(i == trips.size-1 && capacityAllocator.size == 0)
            return true

        if(capacityAllocator.size == 0)
        {
            capacityAllocator.add(trips[i])
            currentCapacity += trips[i][0]

            i++
            continue
        }


        if(trips[i][1] >= capacityAllocator.peek()[2]){
            currentCapacity -= capacityAllocator.peek()[0]
            capacityAllocator.poll()
            continue

        }

        capacityAllocator.add(trips[i])
        currentCapacity += trips[i][0]
        if(currentCapacity > capacity)
            return false

        i++
    }


    return true
}