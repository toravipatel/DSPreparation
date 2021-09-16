package graph_leetcode_course

import array.checkIfExist

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main() {


    var one = IntArray(2)
    one[0] = 0
    one[1] = 1

    var two = IntArray(2)
    two[0] = 1
    two[1] = 2

    var three = IntArray(2)
    three[0] = 2
    three[1] = 0

    var edges = arrayOf(one,two,three)

    println(validPath(3,edges,0,2))

    //println(runLengthEncoding("abbaaaac"))
}

fun validPath(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {

    var graphManager = GraphManager(n)

    edges.forEach {
        graphManager.addConnection(it[0],it[1])
    }


    return graphManager.checkIfPathExist(start, end)
}



class GraphManager(var size:Int){

    var nodeList = ArrayList<LTGraphNode>(size)

    init {
        for (i in 0 until size){
            nodeList.add(LTGraphNode(i, ArrayList<Int>()))
        }
    }

    fun getNode(value: Int):LTGraphNode?{

        for (i in 0..nodeList.size-1){
            if(nodeList[i].value == value)
                return nodeList[i]
        }

        return null
    }

    fun addConnection(source:Int, destination:Int){

        var sourceNode = getNode(source)
        var destinationNode = getNode(destination)

        if(sourceNode == null || destinationNode == null)
            return

        sourceNode.adjcentList?.add(destinationNode.value)
        destinationNode.adjcentList?.add(sourceNode.value)

    }

    fun checkIfPathExist(source:Int, destination: Int):Boolean{

        var graphStack = Stack<LTGraphNode>()
        graphStack.add(getNode(source))
        var visitedNodeSet = HashSet<LTGraphNode>()


        while (!graphStack.isEmpty()){

            var topNode = graphStack.pop()
            if(topNode.value == destination)
                return true

            if(!visitedNodeSet.contains(topNode)){

                visitedNodeSet.add(topNode)

                topNode.adjcentList?.forEach {
                    graphStack.push(getNode(it))
                }

            }

        }

      return false

    }

    fun checkIfPathExistUtil(){

    }

}

class LTGraphNode(var value:Int, var adjcentList:ArrayList<Int>? = null){

}


fun runLengthEncoding(inputString: String): String {


    var length = inputString.length
    var resultString = ""

    var i = 0

    while(i < length){

        var count = 1
        while( i < length-1 && inputString[i] == inputString[i+1] )
        {
            count++
            i++
        }



        resultString = resultString + ""+count + inputString[i]
        i++
    }

    return resultString

}


