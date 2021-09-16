package aug_21_challenge

import java.util.*
import kotlin.collections.ArrayList


//https://leetcode.com/problems/n-ary-tree-level-order-traversal/

class Node(var `val`: Int) {
       var children: List<Node?> = listOf()
}

fun main() {

}

fun levelOrder(root: Node?): List<List<Int>> {

    var resultList = ArrayList<List<Int>>()
    if(root == null)
        return resultList

    var nodeQueue = LinkedList<Node>()
    nodeQueue.add(root)
    //resultList.add(ArrayList<Int>().apply { add(root.`val`) })


    while (!nodeQueue.isEmpty()){

        //var temp = nodeQueue.poll()

        var currentResultList = ArrayList<Int>()

        var currentLevelSize = nodeQueue.size
        for (i in 0 until currentLevelSize){

            var tempNode = nodeQueue.poll()
            tempNode.children?.forEach {
                it?.let { nodeQueue.add(it) }
            }
            currentResultList.add(tempNode.`val`)
            /*tempNode.children?.forEach {
                currentResultList.add(it.`val`)
            }*/
        }
        resultList.add(currentResultList)
    }



    return resultList
}