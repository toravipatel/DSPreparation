package amazon.linkedlist

fun main() {

}

fun reverseList(head: ListNode?): ListNode? {

    if(head == null)
        return head

    var previousNode:ListNode? = null
    var currentNode = head
    var nextNode = head

    while (nextNode != null){

        nextNode = nextNode.next
        currentNode.next = previousNode
        previousNode = currentNode

    }


    return nextNode
}
