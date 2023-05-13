package graph_leetcode_course

import graph.Edge
import java.util.*
import kotlin.collections.HashSet
import kotlin.math.cos

//https://leetcode.com/explore/learn/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3857/
fun main() {


var n = NewA()
    n.test()


}

class NewB:B{
    override fun test() {

    }
}

class New : NewA(), A{

    override fun test() {
        super.test()
    }
}

open class NewA:A{
    override fun test() {
        TODO("Not yet implemented")
    }
}

abstract class MyTest{

    fun test(){

    }
}



interface  A{
    fun test()
}
interface B{
    fun test()
}

class PathUnionByRank (var size:Int){

    var rank = IntArray(size)
    var root = IntArray(size)

    init {

        for (i in 0..size-1){
            root[i] = i
            rank[i] = 1
        }
    }

    fun find( input:Int):Int{
        var data = input
        while (root[data] != data)
            data = root[data]

        return data
    }

    fun union(input1:Int,input2: Int){

        var rootOne = find(input1)
        var rootTwo = find(input2)

       if(rootOne == rootTwo)
           return

        if(rank[rootOne] > rank[rootTwo]){
            root[rootTwo] = rootOne
        }
        else if(rank[rootTwo] > rank[rootOne]){
            root[rootOne] = rootTwo
        }
        else{
            root[rootTwo] = rootOne
            rank[rootOne] += 1
        }




    }

    fun isConnected(input1:Int, input2:Int):Boolean{
        return find(input1) == find(input2)
    }

}

class EDGE(var point1:Int, var point2:Int, var cost:Int)

fun minCostConnectPoints(points: Array<IntArray>): Int {

    if(points.size == 0)
        return 0

    var size = points.size
    var priorityQueue = PriorityQueue<EDGE> { o1, o2 -> o1.cost - o2.cost }
    var pathUnionByRank = PathUnionByRank(size)

    points.forEachIndexed { index, ints ->

        for (j in index+1..size-1){

            var cost = Math.abs(ints[0] - points[j][0]) + Math.abs(ints[1] - points[j][1])
            var edge = EDGE(index, j , cost)
            priorityQueue.add(edge)
        }

    }

    for (i in 0..priorityQueue.size - 1){
        //priorityQueue.p
    }

    var result = 0
    var count = size - 1

    while (count > 0 && !priorityQueue.isEmpty()){

        var edge = priorityQueue.poll()
        if(!pathUnionByRank.isConnected(edge.point1,edge.point2))
        {
            println("cost is "+edge.cost)
            pathUnionByRank.union(edge.point1,edge.point2)
            result += edge.cost
            count--
        }
    }

    return result
}

// with prims algorithm
fun minCostConnectPointsUsingPrims(points: Array<IntArray>): Int {

    if(points.size == 0)
        return 0

    var size = points.size
    var priorityQueue = PriorityQueue<EDGE> { o1, o2 -> o1.cost - o2.cost }
    //var pathUnionByRank = PathUnionByRank(size)

    var result = 0
    var count = size - 1

    var point1 = points[0]

    for (j in 1..size-1){

        var point2 = points[j]
        var cost = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1])
        var edge = EDGE(0,j, cost)
        priorityQueue.add(edge)

    }

    var visitedSet = HashSet<Int>()
    visitedSet.add(0)


    while (count > 0 && !priorityQueue.isEmpty()){

        var edge = priorityQueue.poll()
        var point1 = edge.point1
        var point2 = edge.point2
        var cost = edge.cost

        if(!visitedSet.contains(point2)){

            result += cost
            for (j in 0..size-1){
                if(!visitedSet.contains(j)){
                    var cost = Math.abs(points[point2][0]- points[j][0]) + Math.abs(points[point1][1] - Math.abs(points[j][1]))
                    priorityQueue.add(EDGE(point2,j,cost))
                }
            }

            count--
        }



    }



    return result
}