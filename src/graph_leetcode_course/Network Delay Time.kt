package graph_leetcode_course

import com.sun.jdi.IntegerValue
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.cos

//https://leetcode.com/problems/network-delay-time/description/

var sourceAdjc = HashMap<Int, ArrayList<Pair<Int, Int>>>()
fun main() {

   var a = 1
   Math.pow(2.0, a.toDouble())


}

fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {

    var result = Int.MIN_VALUE


    times.forEach {

        var source = it[0]
        var destination = it[1]
        var cost = it[2]

        sourceAdjc.putIfAbsent(source, ArrayList())
        sourceAdjc.get(source)?.add(Pair(cost, destination))
    }

    var costArray = IntArray(n-1)
    Arrays.fill(costArray, Int.MAX_VALUE)

    dijkstra(costArray, n, k)

    costArray.forEach {

        result = Math.max(result, it )
    }

    if(result == Int.MAX_VALUE)
        return -1

    return result
}

fun dijkstra(costArray: IntArray, n: Int, k: Int) {

    var nodeQueue = PriorityQueue<Pair<Int,Int>>{o1,o2->
        o1.first - o2.first
    }

    nodeQueue.add(Pair(0,n))
    costArray[n] = 0

    var visitedNode = HashSet<Int>()

    while (!nodeQueue.isEmpty()){

        var currentNode = nodeQueue.poll()
        var destination = currentNode.second
        var cost = currentNode.first

        if(costArray[n] < cost)
            continue

        if(visitedNode.contains(destination)){
            continue
        }

        visitedNode.add(destination)

        sourceAdjc.get(destination)?.forEach {

            if(costArray[it.second] > cost + it.first){
                costArray[it.second] = cost + it.first
            }

            nodeQueue.add(Pair(costArray[it.second], it.second))

        }
    }


}

