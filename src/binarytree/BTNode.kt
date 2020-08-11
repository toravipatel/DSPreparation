package binarytree

class BTNode(var leftNode:BTNode?=null,var rightNode:BTNode?=null,var value:Int =0 )

class BTManager{

    public var rootNode:BTNode? = null

    fun add(value: Int){
        if(rootNode == null)
            rootNode = BTNode(value = value)
        else
            addNode(rootNode!!,value = value)
    }

    fun addNode(currentNode:BTNode, value:Int):BTNode{



        if(value < currentNode.value)
            currentNode.leftNode = currentNode.leftNode?.let { addNode(it,value) }
        else if(value > currentNode.value)
            currentNode.rightNode = currentNode.rightNode?.let { addNode(it,value) }
        else
            return currentNode

        return currentNode

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

}

fun main() {

    val binaryTReeManager = BTManager()

    for(i in 0..10){
        binaryTReeManager.add(i)
    }

    binaryTReeManager.rootNode?.let { binaryTReeManager.readBinaryTree(it) }



}