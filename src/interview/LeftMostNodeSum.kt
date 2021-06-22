package interview

import binarytree.BTNode


fun main() {
    val leftMostNodeSum = LeftMostNodeSum()
    leftMostNodeSum.calculateSum(BTNode(null,null, 10))
    println(leftMostNodeSum.sum)
}

class LeftMostNodeSum {

    var sum = 0

    fun calculateSum(node:BTNode){

        if(node == null)
            return

        calculateSum(node.leftNode!!)
        if(node.rightNode != null)
            sum = sum + node.value
        calculateSum(node.rightNode!!)

    }
}

