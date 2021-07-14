package amazon.tree_graph

fun main() {

}

var minDiff = Int.MAX_VALUE

fun getMinimumDifference(root: TreeNode?): Int {

    getMinimumDifference(root)
    return minDiff


}

fun getMinimumDiffUtil(root:TreeNode?){
    if(root == null)
        return

    if(root.left != null){
        minDiff = Math.min(Math.abs(root.`val` - root.left!!.`val`), minDiff)
        getMinimumDiffUtil(root.left)
    }

    root.right?.let {
        println("${Math.abs(root.`val` - it.`val`)}")
        minDiff = Math.min(Math.abs(root.`val` - it.`val`), minDiff)
        getMinimumDiffUtil(it)
    }

}