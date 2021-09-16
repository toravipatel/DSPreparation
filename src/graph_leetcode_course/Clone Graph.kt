package graph_leetcode_course

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() {

}

class Node(var `val`: Int) {
         var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

fun cloneGraph(node: Node?): Node? {

    if(node == null)
        return null

    var visitedMap = HashMap<Node,Node>()

    var linkedList = LinkedList<Node>()
    linkedList.add(node)

    visitedMap.put(node, Node(node.`val`))


    while (linkedList.isEmpty()){

        var popNode = linkedList.pop()
        println("poped node value is ${popNode.`val`}")

        popNode.neighbors.forEach {

            it?.let {

                println("neighbour value is ${it.`val`}")


                if(!visitedMap.containsKey(it)){
                    visitedMap.put(it, Node(it.`val`))
                }
                visitedMap.get(popNode)?.neighbors?.add(it)

            }
        }

    }


    return visitedMap.get(node)
}