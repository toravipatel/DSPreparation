package graph_leetcode_course

import java.util.*

//https://leetcode.com/explore/learn/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3857/
fun main() {



}

data class KEdge(var point0:Int, val point1:Int , var cost:Int)

class Solution {


    fun minCostConnectPoints(points: Array<IntArray>): Int {

        var priorityQueue = PriorityQueue<KEdge>{o1, o2 -> o1.cost - o2.cost }
         var kruskalUnionByRank = KruskalUnionByRank(points.size)


        for (i in 0..points.size-1){

           for (j in i+1..points.size-1){

               var cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])
               priorityQueue.add(KEdge(i,j,cost))

           }

       }

       //var nodeQueue = LinkedList<KEdge>()

       //var edge = priorityQueue.poll()

       //nodeQueue.add(edge)

        var count = points.size - 1


        var result = 0

        while (!priorityQueue.isEmpty() && count > 0){

            var currentEdge = priorityQueue.poll()
            if(!isCycle(kruskalUnionByRank, currentEdge.point1,currentEdge.point0)){

                kruskalUnionByRank.union(currentEdge.point0,currentEdge.point1)
                result =+ currentEdge.cost
                count--
            }


        }

        return result

    }

    fun isCycle(kruskalUnionByRank:KruskalUnionByRank, x:Int, y:Int):Boolean{

        return kruskalUnionByRank.find(x) == kruskalUnionByRank.find(y)

    }
}

class KruskalUnionByRank(var size:Int)
{
    var nums = IntArray(size)
    var rank = IntArray(size)

    init {
        for (i in 0..size - 1){
            nums[i] = i
            rank[i] = 1
        }
    }

    fun find(x:Int):Int{

        var temp = x

        while(temp != nums[temp]){
            temp = nums[temp]
        }

        return temp
    }

    fun connected(x:Int, y:Int):Boolean{
        return find(x) == find(y)
    }

    fun union(x:Int, y:Int){
        var rootX = find(x)
        var rootY = find(y)

        if(rootX == rootY)
            return

        if(rank[rootX] > rank[rootY]){
            nums[rootY] = rootX
        }
        else if(rank[rootY] > rank[rootX]){
            nums[rootX] = rootY

        }else{
            nums[rootX] = rootY
            rank[rootY] =+ 1
        }
    }

}

