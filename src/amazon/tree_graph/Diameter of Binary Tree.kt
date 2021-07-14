package amazon.tree_graph

fun main() {

}

var diameter = 0

fun diameterOfBinaryTree(root: TreeNode?): Int {

    longestDepth(root)
    return diameter
}

fun longestDepth(node:TreeNode?):Int{

    if(node == null)
        return 0

    var leftDepth = longestDepth(node.left)
    var rightDepth = longestDepth(node.right)

    diameter = Math.max(diameter, leftDepth + rightDepth)

    return Math.max(leftDepth, rightDepth) + 1
}