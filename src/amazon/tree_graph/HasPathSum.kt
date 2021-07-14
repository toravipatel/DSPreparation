package amazon.tree_graph

import java.util.*

fun main() {

}

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {

    if(root == null)
        return false


    var nodeStack = Stack<TreeNode>()
    var sumStack = Stack<Int>()

    nodeStack.add(root)
    sumStack.add(targetSum - root.`val`)
    var currentSum = 0

    while (!nodeStack.isEmpty()){

        var lastNode = nodeStack.pop();
        var currentSum = sumStack.pop()

        if(lastNode.left == null && lastNode.right == null && currentSum == 0)
            return true

        if(lastNode.left != null)
        {
            nodeStack.push(lastNode.left)
            sumStack.push(currentSum - lastNode.left!!.`val`)
        }

        if(lastNode.right != null)
        {
            nodeStack.push(lastNode.right)
            sumStack.push(currentSum - lastNode.right!!.`val`)
        }
    }


    return false
}