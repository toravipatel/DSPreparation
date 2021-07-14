package amazon.tree_graph

import java.util.*
import kotlin.collections.ArrayList

//https://leetcode.com/problems/path-sum-ii/

fun main() {

}

fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    var finalResultList = ArrayList<ArrayList<Int>>()


    if(root == null)
        return finalResultList


    var nodeStack = Stack<TreeNode>()
    var sumStack = Stack<Int>()
    var nodeStackList = Stack<ArrayList<Int>>()

    nodeStack.add(root)
    sumStack.add(targetSum - root.`val`)
    nodeStackList.add(ArrayList<Int>().apply { add(root.`val`) })
    var currentSum = 0

    var currentList = ArrayList<Int>()

    while (!nodeStack.isEmpty()){

        var lastNode = nodeStack.pop();
        //currentList.add(lastNode.`val`)
        var currentSum = sumStack.pop()

        var currentTraversedList = nodeStackList.pop()

        if(lastNode.left == null && lastNode.right == null)
        {
            if(currentSum == 0){
                finalResultList.add(currentTraversedList)
                //currentList.removeAt(currentList.size-1)

            }

        }

        if(lastNode.left != null)
        {
            nodeStack.push(lastNode.left)
            sumStack.push(currentSum - lastNode.left!!.`val`)

            var newList = ArrayList<Int>()
            newList.addAll(currentTraversedList)
            newList.add(lastNode.left!!.`val`)
            nodeStackList.push(newList)
        }

        if(lastNode.right != null)
        {
            nodeStack.push(lastNode.right)
            sumStack.push(currentSum - lastNode.right!!.`val`)
            var newList = ArrayList<Int>()
            newList.addAll(currentTraversedList)
            newList.add(lastNode.right!!.`val`)
            nodeStackList.push(newList)

        }
    }


    return finalResultList


}