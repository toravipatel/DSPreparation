package graph

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main() {

    var graphManagerImpl = GraphManagerImpl()
    graphManagerImpl.addNode(1)
    graphManagerImpl.addNode(2)
    graphManagerImpl.addNode(3)
    graphManagerImpl.addNode(4)
    graphManagerImpl.addNode(5)

    graphManagerImpl.addConnection(1,2)
    //graphManagerImpl.addConnection(2,1)

    graphManagerImpl.addConnection(1,3)
    graphManagerImpl.addConnection(1,4)
    graphManagerImpl.addConnection(2,5)
    graphManagerImpl.addConnection(4,5)

    graphManagerImpl.doBFSTraversal(1)
    println("--------------")
    graphManagerImpl.doDFSTraversal(1)

}

class GraphManagerImpl{

    var nodeList = LinkedList<GraphNode>()

    fun addNode(value:Int){
        var graphNode = GraphNode(value)
        graphNode.adjcentList = ArrayList()
        nodeList.add(graphNode)
    }

    fun addConnection(source:Int,destination:Int){

        //var sourceNode =

            getNode(source).adjcentList?.add(getNode(destination))

        var destinationNode = getNode(destination)

        getNode(destination).adjcentList?.add(getNode(source))
    }
    fun getNode(value:Int):GraphNode{

        nodeList.forEach {
            if(it.value == value)
                return it
        }

        return GraphNode(value)
    }

    fun doDFSTraversal(startValue:Int){

        var startNode = getNode(startValue)

        var visitedNode = HashSet<GraphNode>()

        DFSUtil(startValue,visitedNode)

    }

    fun DFSUtil(startNodeValue: Int, visitedNode:HashSet<GraphNode>){

        var node = getNode(startNodeValue)
        println("visited node value is ${node.value}")
        visitedNode.add(node)

        node.adjcentList?.forEach {

            if(!visitedNode.contains(it)){
                DFSUtil(it.value,visitedNode)
            }

        }


    }

    fun doBFSTraversal(startNodeValue:Int){

        var startNode = getNode(startNodeValue)
        var visitedNodeSet = HashSet<GraphNode>()

        var nodeQueue = LinkedList<GraphNode>()
        nodeQueue.add(startNode)

        while (!nodeQueue.isEmpty()){

            var node = nodeQueue.pollFirst()
            //println(node.value)

            visitedNodeSet.add(node)
            node.adjcentList?.forEach {
                if(!visitedNodeSet.contains(it))
                {
                    nodeQueue.add(it)
                }
            }

        }

        visitedNodeSet.forEach {

            println(it.value)
        }

    }


}



class GraphNode(var value:Int,var adjcentList: ArrayList<GraphNode>? = null){

    override fun hashCode(): Int {
        return this.value
    }

    override fun equals(other: Any?): Boolean {
        return this.value == (other as Node).value
    }
}

data class test(var data:Int){


    override fun toString(): String {
        return ""
    }
}