package graph_leetcode_course

import java.util.*
import kotlin.collections.ArrayList

fun main() {

}

var resultList = ArrayList<List<Int>>()
var targetNode = 0

var graphData: Array<IntArray>? = null


fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {

    var sourceNode = 0
    targetNode = graph.size - 1
    graphData = graph

    var currentList = LinkedList<Int>()
    currentList.addLast(0)


    allPathsSourceTargetUtil(0, currentList)

    return resultList
}

fun allPathsSourceTargetUtil(node: Int, currentList: LinkedList<Int>) {
    if (node == targetNode) {
        resultList.add(ArrayList<Int>().apply { addAll(currentList) })
        return
    }

    graphData?.get(node)?.forEach {

        currentList.addLast(it)
        allPathsSourceTargetUtil(it,currentList)

        currentList.removeLast()
    }
}

