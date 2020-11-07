package linkedlist

fun main() {

        var myLinkedList = MyLinkedList()
        myLinkedList.addAtHead(10)
        myLinkedList.addAtTail(20)
        myLinkedList.addAtTail(40)
        myLinkedList.addAtTail(50)
        myLinkedList.addAtIndex(2,30)
        myLinkedList.deleteAtIndex(2)

}

data class LTNode(val value:Int, var next:LTNode?)

class MyLinkedList() {

    /** Initialize your data structure here. */

    var head:LTNode? = null

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {

        var i = 0
        var currentNode = head
        while (i< index){
            currentNode = currentNode?.next
        }
        return currentNode!!.value
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {

        var newNode = LTNode(`val`,null)
        head = newNode

    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {

        var newNode = LTNode(`val`,null)
        var currentPointer = head

        while(currentPointer?.next != null){
            currentPointer = currentPointer?.next
        }

        currentPointer?.next = newNode


    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {


        if(index == 1)
        {
            head?.next = LTNode(`val`,null)
            return
        }

        val newNode = LTNode(`val`,null)

        var currentNode = head
        var previousNode:LTNode? = null
        var i = 0
        while (i < index ){
            previousNode = currentNode
            currentNode = currentNode?.next
            i++
        }

        newNode.next = currentNode
        previousNode?.next = newNode




    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {

        var currentNode = head
        var previousNode:LTNode? = null
        var i = 0
        while (i < index ){
            previousNode = currentNode
            currentNode = currentNode?.next
            i++
        }

        previousNode?.next = currentNode?.next
        currentNode = null

    }

    fun hasCycle(head: LTNode?): Boolean {


        var slowPointer:LTNode? = head
        var fastPointer:LTNode? = head

        while (fastPointer != null){

            if(slowPointer?.value == fastPointer?.value)
                return true

            slowPointer = slowPointer?.next
            fastPointer = fastPointer?.next?.let { it.next } ?:run{ null }

        }

        return false

    }

}