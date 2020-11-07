package binarytree

class DepthTreeNode(var `val`: Int) {
    var left: DepthTreeNode? = null
    var right: DepthTreeNode? = null
}

class DepthSolution {
    var answer = 0

    fun maxDepth(root: DepthTreeNode?): Int {
        maxDepthUtility(root,1)
        return answer
    }

    fun maxDepthUtility(root:DepthTreeNode?, depth:Int){

        if(root == null)
            return

        if(root!!.left == null && root!!.right == null){
            answer = Math.max(depth,answer)
        }

        maxDepthUtility(root!!.left,depth+1)
        maxDepthUtility(root!!.right,depth+1)

    }

    fun hasPathSum(root: DepthTreeNode?, sum: Int): Boolean {

        return hasPathSumUtility(root,0,sum)
    }
    private fun hasPathSumUtility(root:DepthTreeNode?,currentSum:Int,sum: Int):Boolean{

        if(root == null)
            return false

        answer = answer+ root.`val`

        if(answer == sum)
            return true

        return hasPathSumUtility(root.left,answer,sum)
        return hasPathSumUtility(root.right,answer,sum)

        return true
    }
}