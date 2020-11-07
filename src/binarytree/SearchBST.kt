package binarytree

import recursion.TreeNode


fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {

        if(root == null)
            return null

        if(root!!.`val` == `val`)
            return root
        else if(root!!.`val` > `val`)
            return searchBST(root!!.right,`val`)
        else
            return searchBST(root!!.left,`val`)



    }

    fun closestValue(root: TreeNode?, target: Double): Int {

        return 0
    }

    fun maxDepth(root: TreeNode?): Int {


        return maxDepthUtility(root,1)
    }

    fun maxDepthUtility(root: TreeNode?,depth:Int):Int{

        if(root?.left == null && root?.right == null)
            return 0


        if(root?.left != null)
            maxDepthUtility(root!!.left,depth+1)


        return 0
    }


}