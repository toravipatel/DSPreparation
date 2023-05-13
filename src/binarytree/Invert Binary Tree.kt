package binarytree

import java.util.*

//https://leetcode.com/problems/invert-binary-tree/
fun main() {

}

fun invertTree(root: TreeNode?): TreeNode? {

    if(root == null)
        return root

    var nodeQueue = LinkedList<TreeNode>()
    nodeQueue.add(root)


    while (!nodeQueue.isEmpty()){

        var currentNode = nodeQueue.poll()

        //swap the node
        var temp = currentNode.left
        currentNode.left = currentNode.right
        currentNode.right = temp

       /* currentNode.left?.let { nodeQueue.add(it) }
        currentNode.right?.let { nodeQueue.add(it) }*/

    }




    return root
}