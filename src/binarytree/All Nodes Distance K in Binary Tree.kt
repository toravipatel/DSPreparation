package binarytree

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet


class SolutionData {


    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    val parentMap = HashMap<TreeNode, TreeNode?>()


    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {


        val resultList = ArrayList<Int>()

        if (root == null)
            return resultList

        if(target == null)
            return resultList

        getParentLinking(root, null)

        var seenNode = HashSet<TreeNode>()
        seenNode.add(target)

        var nodeQueue:Queue<TreeNode> = LinkedList<TreeNode>()
        nodeQueue.add(target)
        var currentLevel = 1

        while (!nodeQueue.isEmpty() && currentLevel != k) {

            if(currentLevel == k){

                nodeQueue.forEach {

                    resultList.add(it.`val`)
                }

                return resultList
            }

            var currentLevelSize = nodeQueue.size

            while (currentLevel >= 0) {

                var node = nodeQueue.remove()

                if (node.left != null)
                    nodeQueue.add(node.left!!)

                if (node.right != null)
                    nodeQueue.add(node.right!!)

                val parent = parentMap.get(node)
                if (parent != null && !seenNode.contains(parent)) {
                    nodeQueue.add(parent)
                    seenNode.add(parent)
                }
            }
        }

        return resultList

    }

    fun getParentLinking(root: TreeNode?, parent: TreeNode?) {

        if (root != null) {
            parentMap.put(root, parent)
            getParentLinking(root.left, root)
            getParentLinking(root.right, root)

        }

    }
}