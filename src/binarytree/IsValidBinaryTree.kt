package binarytree

fun main() {
    println(isBSTUtil(MNode(10),Int.MIN_VALUE, Int.MAX_VALUE))
}

fun isBSTUtil(node:MNode?, minValue:Int, maxValue:Int):Boolean {
    if(node == null)
        return true

   /* if( (node.`val` < maxValue && node.`val` > minValue) && isBSTUtil(node.left, minValue, node.`val`) && isBSTUtil(node.right,node.`val`,maxValue) ){
        return true
    }
    else
         return false*/

    return true

}

class MNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}