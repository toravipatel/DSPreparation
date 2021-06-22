package amazon.tree_graph

import binarytree.BTNode
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

fun main() {

}
class BSTManager{

    var lastVisitedValue = Int.MIN_VALUE

    fun isValidBST(root: BTNode?): Boolean {



        return true
    }

    fun maxDepth(root: BTNode?): Int {

        if(root == null)
            return -1

        var leftDepth = maxDepth(root.leftNode) + 1
        var rightDepth = maxDepth(root.rightNode) + 1


        return max(leftDepth,rightDepth)

    }

    fun isSymmetric(root: BTNode?): Boolean {

        if(root == null)
            return true

        val nodeQueue = LinkedList<BTNode?>()
        nodeQueue.add(root)
        nodeQueue.add(root)

        while (!nodeQueue.isEmpty()){

            var leftNode = nodeQueue.pop()
            var rightNode = nodeQueue.pop()

            if(leftNode == null && rightNode == null)
                continue
            if(leftNode == null || rightNode == null)
                return false
            if(leftNode.value != rightNode.value)
                return false

            nodeQueue.add(leftNode.leftNode)
            nodeQueue.add(rightNode.rightNode)
            nodeQueue.add(leftNode.rightNode)
            nodeQueue.add(rightNode.leftNode)

        }
        return true
    }

    fun isSymmetricUtil(left:BTNode?, right:BTNode?):Boolean{
        if(left != null && right != null)
        {

        }
        else
            return left!!.value == right!!.value

        return true

    }

    fun levelOrder(root: BTNode?): List<List<Int>> {

        val resultList = ArrayList<ArrayList<Int>>()

        if(root == null)
            return resultList

        val nodeQueue = LinkedList<BTNode>()
        nodeQueue.add(root)

        while (!nodeQueue.isEmpty()){

            val levelList = ArrayList<Int>()
            var currentSize = nodeQueue.size

            while (currentSize > 0){

                val tempNode = nodeQueue.pop()
                if(tempNode.leftNode != null)
                    nodeQueue.add(tempNode.leftNode!!)
                if(tempNode.rightNode != null)
                    nodeQueue.add(tempNode.rightNode!!)

                levelList.add(tempNode.value)
                currentSize--
            }
            resultList.add(levelList)
        }
        return resultList
    }

    fun zigzagLevelOrder(root: BTNode?): List<List<Int>> {

        val resultList = LinkedList<LinkedList<Int>>()
        var isLeftToRight = false

        if(root == null)
            return resultList

        val nodeQueue = LinkedList<BTNode>()
        nodeQueue.add(root)

        while (!nodeQueue.isEmpty()){

            val levelList = LinkedList<Int>()
            var currentSize = nodeQueue.size

            while (currentSize > 0){

                val tempNode = nodeQueue.pop()
                if(isLeftToRight)
                {
                    if(tempNode.leftNode != null)
                        nodeQueue.addLast(tempNode.leftNode!!)
                    if(tempNode.rightNode != null)
                        nodeQueue.addLast(tempNode.rightNode!!)
                }
                else{
                    if(tempNode.rightNode != null)
                        nodeQueue.addLast(tempNode.rightNode!!)
                    if(tempNode.leftNode != null)
                        nodeQueue.addLast(tempNode.leftNode!!)
                }

                if(isLeftToRight)
                    levelList.addFirst(tempNode.value)
                else
                    levelList.addLast(tempNode.value)

                currentSize--
            }
            resultList.add(levelList)
        }
        return resultList

    }
}





