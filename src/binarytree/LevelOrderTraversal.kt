package binarytree

import java.util.*
import kotlin.collections.ArrayList

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNodeBT(var `val`: Int) {
         var left: TreeNodeBT? = null
         var right: TreeNodeBT? = null
     }



class SolutionTest{


    fun levelOrder(root: TreeNodeBT?): List<List<Int>> {
        var list = ArrayList<ArrayList<Int>>()


        var treeQueue = PriorityQueue<TreeNodeBT>()
        treeQueue.add(root)
        //list.add(listOf(root!!.`val`))
        //list.add(root!!.`val`)



        while (!treeQueue.isEmpty()){

            var levelList = ArrayList<Int>()
            list.add(levelList)

            for (i in 0..treeQueue.size){


                var node:TreeNodeBT = treeQueue.remove()

                node?.right?.let {
                    treeQueue.add(it)
                    levelList.add(it.`val`)
                }

                node?.left?.let {
                    treeQueue.add(it)
                    levelList.add(it.`val`)
                }

            }



        }
        return list
    }


}