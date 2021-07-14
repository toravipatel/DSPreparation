package walmart.easy

import amazon.tree_graph.TreeNode

fun main() {

}

var minDiff = Double.MAX_VALUE
var nodeValue = Int.MAX_VALUE

fun closestValue(root: TreeNode?, target: Double): Int {

    closestValueUtility(root,target)
    return nodeValue
}

fun closestValueUtility(node:TreeNode?,target: Double){
    if(node == null)
        return

    closestValueUtility(node.left,target)

    var diff = Math.abs(target - node.`val`)
    if(diff < minDiff) {
        minDiff = diff
        nodeValue = node.`val`
    }
    closestValueUtility(node.right,target)
}