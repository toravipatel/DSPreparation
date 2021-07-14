package walmart.easy

import amazon.tree_graph.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {

}

val nodeList = ArrayList<Int>()

fun rightSideView(root: TreeNode?): List<Int> {

    if(root == null)
        return nodeList

    val nodeQueue = ArrayDeque<TreeNode>()
    nodeQueue.push(root)

    while (!nodeQueue.isEmpty()){

        val currentLevelSize = nodeQueue.size
        for (i in 0..currentLevelSize-1){

            val tempNode = nodeQueue.poll()
            if(i == currentLevelSize - 1)
                nodeList.add(tempNode.`val`)

            if(tempNode.left != null)
                nodeQueue.push(tempNode.left)
            if(tempNode.right != null)
                nodeQueue.push(tempNode.right)
        }
    }
    return nodeList
}

fun rightSideViewUtility(root: TreeNode?) {
    if(root == null)
        return

    rightSideViewUtility(root.right)
    nodeList.add(root.`val`)
}
