package linkedlist

import amazon.linkedlist.ListNode


fun main() {

}

fun swapPairs(head: ListNode?): ListNode? {

    if(head == null)
        return null

    var dummyNode = ListNode(-1)
    dummyNode.next = head

    var previousNode:ListNode = dummyNode

    var current = head

    while (current != null && current.next != null){

        var firstNode = current
        var secondNode = current.next

        previousNode.next = secondNode
        firstNode.next = secondNode!!.next
        secondNode.next = firstNode

        previousNode = firstNode
        current = previousNode


    }



    return dummyNode.next

}