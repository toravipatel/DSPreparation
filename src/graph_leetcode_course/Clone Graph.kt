package graph_leetcode_course

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() {

}

class Node(var `val`: Int) {
         var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}


fun cloneGraphNewPractise(node: Node?):Node?{

    if(node == null)
        return null

    var nodeQueue = LinkedList<Node>()
    var visitedMap = HashMap<Node,Node>()


    nodeQueue.add(node)
    visitedMap[node] = Node(node.`val`)

    while (!nodeQueue.isEmpty()){

        var currentNode = nodeQueue.pop()

        currentNode?.neighbors?.forEach {
            it?.let {

                if(!visitedMap.containsKey(it)){
                    visitedMap[it] = Node(it.`val`)
                    nodeQueue.add(it)
                }

                visitedMap.get(currentNode)?.neighbors?.add(visitedMap[it])
            }
        }
    }


    return visitedMap[node]
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