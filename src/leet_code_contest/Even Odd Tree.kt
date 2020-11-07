package leet_code_contest

import recursion.TreeNode
import java.util.*
import javax.lang.model.util.ElementScanner6

fun main() {

}

fun isEvenOddTree(root: TreeNode?): Boolean {

    if (root == null)
        return false

    var dataQueue = LinkedList<TreeNode>()
    if(root!!.`val`%2 != 0)
        dataQueue.add(root)
    else
        return false


    var evenLevel = true
    while (!dataQueue.isEmpty()) {

        evenLevel = !evenLevel

        var previousValue = if (evenLevel) Int.MIN_VALUE else Int.MAX_VALUE


        var currentLevelSize = dataQueue.size
        var i = 0

        while (i < currentLevelSize) {

            var popElement = dataQueue.pop()
            var leftNode = popElement?.left
            var rightNode = popElement?.right

            if (evenLevel) {

                leftNode?.let {
                    if (it.`val` % 2 != 0 && previousValue < it.`val`) {
                        dataQueue.add(leftNode)
                        previousValue = it.`val`
                    } else
                        return false
                }

                rightNode?.let {
                    if (it.`val` % 2 != 0 && previousValue < it.`val`) {
                        dataQueue.add(rightNode)
                        previousValue = it.`val`
                    } else
                        return false
                }

            } else {
                leftNode?.let {
                    if (it.`val` % 2 == 0 && previousValue > it.`val`) {
                        dataQueue.add(leftNode)
                        previousValue = it.`val`
                    } else
                        return false
                }

                rightNode?.let {
                    if (it.`val` % 2 == 0 && previousValue > it.`val`) {
                        dataQueue.add(rightNode)
                        previousValue = it.`val`
                    } else
                        return false
                }

            }


            i++
        }


    }


    return true

}