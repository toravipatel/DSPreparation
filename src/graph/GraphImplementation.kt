package graph

import java.util.*
import kotlin.collections.LinkedHashSet

class Node(var value:Int)
{

    lateinit var adjecentList:LinkedList<Node>

    init {
        adjecentList = LinkedList()
    }

    override fun hashCode(): Int {
        return this.value
    }

    override fun equals(other: Any?): Boolean {
        return this.value == (other as Node).value
    }
}

class Edge(val startNode:Node,val endNode:Node,cost:Int){

}

class GraphImplementation{

    lateinit var nodeList:LinkedList<Node>
    val dsMap = HashMap<Long,DSNode>()


    init {
        nodeList = LinkedList()
    }

    fun addNode(newNodeValue:Int){

        var newNode = Node(newNodeValue)
        nodeList.add(newNode)

    }

    fun createNodeConnection(value1:Int,value2:Int){

        var node1 = Node(value1)
        var node2 = Node(value2)

        nodeList.forEach {

            if(it.value == value1){
                it.adjecentList.add(node2)
            }
            if(it.value == value2 )
            {
                it.adjecentList.add(node1)
            }

        }
    }


    fun getNode(value:Int):Node?{

        nodeList.forEach {

            if(it.value == value)
                return it

        }

        return null
    }

    fun BFSTraversal(startNodeValue:Int){


        var visitedNodeSet = LinkedHashSet<Node>()

        var node:Node? = null

        getNode(startNodeValue)?.let {
            visitedNodeSet.add(it)

            node = it
        }


        val nodeQueue = ArrayDeque<Node>()
        nodeQueue.push(node)
        node?.let { visitedNodeSet.add(it) }

        while (!nodeQueue.isEmpty()){


            var deletedNode = nodeQueue.pop()
            visitedNodeSet.add(deletedNode)

            print("${deletedNode.value} ->")

            deletedNode.adjecentList.forEach {

                if(!visitedNodeSet.contains(it))
                {
                    nodeQueue.add(getNode(it.value))
                }

            }


        }

    }

    fun DFSTraversal(startNodeValue:Int,visitedNodeSet:LinkedHashSet<Node>){

        val node = Node(startNodeValue)

        if(!visitedNodeSet.add(node))
            return
        else
        {
            //print("$startNodeValue   "+"->")


            getNode(startNodeValue)?.adjecentList?.forEach {

                if(!visitedNodeSet.contains(it)) {
                    DFSTraversal(it.value,visitedNodeSet)

                }
            }
            DFSTraversal(visitedNodeSet.elementAt(visitedNodeSet.size-1).value,visitedNodeSet)
        }

    }


    /*fun kruskalMST(){

        val priorityQueue = PriorityQueue<Node>(kotlin.Comparator { o-> o.value })

    }*/

    fun isCycle():Boolean{

        val visitedNodeLinkedSet = LinkedHashSet<Node>()


        nodeList.forEachIndexed { index, node ->

            visitedNodeLinkedSet.clear()

            if(isCycleUtil(node.value,visitedNodeLinkedSet,-1))
                return true

        }

        return false

    }

    fun isCycleUtil(data:Int,visitedNodeLinkedSet:LinkedHashSet<Node>,parent:Int):Boolean{

        var isCycleFlag:Boolean = false

        val currentNode = getNode(data)
        val parentNode = getNode(parent)

        currentNode?.let { visitedNodeLinkedSet.add(it) }


        if(currentNode?.adjecentList?.size!! >0)
        {

            for (i in currentNode.adjecentList)
            {

                if(!visitedNodeLinkedSet.contains(i)) {
                    isCycleUtil(i.value, visitedNodeLinkedSet,currentNode.value)
                }
                else if(i.value != parentNode?.value)
                {
                    isCycleFlag = true
                    break
                }

            }
        }
        return isCycleFlag

    }


    fun readGraph(){
        nodeList.forEach {


            println()
            print("${it.value} ->")

            it.adjecentList.forEach {

                print("${it.value} , ")
            }

        }
    }

}

fun main() {

    val graphManager = GraphImplementation()

    for(i in 0..7){
        graphManager.addNode(i)
    }

    graphManager.createNodeConnection(0,5)
    graphManager.createNodeConnection(0,6)

    graphManager.createNodeConnection(0,7)
    graphManager.createNodeConnection(5,1)
    graphManager.createNodeConnection(5,2)

    graphManager.createNodeConnection(2,1)
    graphManager.createNodeConnection(6,3)
    graphManager.createNodeConnection(7,4)



   /* graphManager.readGraph()

    val visitedNodeList = LinkedHashSet<Node>()

    graphManager.DFSTraversal(2,visitedNodeList)
    println("DFS traversal is")
    visitedNodeList.forEach {
        print("${it.value}")
    }*/


    println(graphManager.isCycle())

   /* println("-------------")

    graphManager.BFSTraversal(0)*/




}
