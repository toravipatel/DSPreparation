package binarytree

import recursion.TreeNode

class BTNode(var leftNode:BTNode?=null,var rightNode:BTNode?=null,var value:Int =0 )

class BTManager{

    public var rootNode:BTNode? = null

    fun add(value: Int){
        if(rootNode == null)
            rootNode = BTNode(value = value)
        else
            addNode(rootNode!!,value = value)
    }

    fun addNode(currentNode:BTNode, value:Int){


        if(value < currentNode.value)
        {
            if(currentNode.leftNode == null){
                currentNode.leftNode = BTNode(value = value)
                return
            }
            currentNode.leftNode?.let { addNode(it,value) }
        }
        else if(value > currentNode.value)
        {
            if(currentNode.rightNode == null){
                currentNode.rightNode = BTNode(value = value)
                return
            }
            currentNode.rightNode?.let { addNode(it,value) }
        }




    }

    fun readBinaryTree(node:BTNode){
        if(node == null)
            return
        else
        {
             val tempNode = node
             while (tempNode != null){
                 tempNode.leftNode?.let { readBinaryTree(it) };
                 System.out.print(" " + tempNode.value);
                 tempNode.rightNode?.let { readBinaryTree(it) };
             }
        }
    }

    fun checkIfNodeExists(value: Int):Boolean{

        if(rootNode == null){
            return false
        }


        return nodeExistsUtil(rootNode!!,value)

    }

    fun nodeExistsUtil(rootNode: BTNode?,value: Int):Boolean{

        if(rootNode == null)
            return false

        if(rootNode.value == value)
            return true

        return if(rootNode.value>value)
            nodeExistsUtil(rootNode.leftNode,value)
        else
            nodeExistsUtil(rootNode.rightNode,value)

        //return  false
    }

    fun rangeSumBST(node:BTNode,left:Int,right:Int):Int{

        return 0


    }

    fun rangeSumBSTUtility(){

    }

}

fun main() {

    val binaryTReeManager = BTManager()

    for(i in 0..10){
        binaryTReeManager.add(i)
    }

    //binaryTReeManager.rootNode?.let { binaryTReeManager.readBinaryTree(it) }

    println(binaryTReeManager.checkIfNodeExists(11))



}
