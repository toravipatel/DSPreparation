package sorting

import java.util.*


class ListNode(var `val`: Int) {
     var next: ListNode? = null
 }

class LinkedListManager{

    var head:ListNode? = null

    fun addNode(newNode:ListNode){

        if(head == null)
            head = newNode
        else{

            var tempNode = head
            while (tempNode!!.next!= null)
            {
                tempNode = tempNode.next
            }

            tempNode.next= newNode

        }

    }

}

fun main() {

    var list1:ListNode = ListNode(1)
    var list2:ListNode = ListNode(3)
    var list3:ListNode = ListNode(5)
    var list4:ListNode = ListNode(7)

    var manager = LinkedListManager()
    manager.addNode(list1)
    manager.addNode(list2)
    manager.addNode(list3)
    manager.addNode(list4)


    var manager2 = LinkedListManager()
    for (i in 0..5 step 2)
        manager2.addNode(ListNode(i))


    var result:ListNode = mergeTwoLists(manager.head,manager2.head)!!

    while (result!= null)
    {
        println(result.`val`)
        result = result.next!!
    }





}


fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

    var tempNode = ListNode(0)
    tempNode.next = null

    var list1 = l1
    var list2 = l2

    while (list1!= null && list2!= null)
    {
        if(list1!!.`val` <= list2!!.`val`)
        {
            tempNode.next = ListNode(list1.`val`)
            list1 = list1.next
        }else{
            tempNode.next = ListNode(list2.`val`)
            list2 = list2.next
        }
    }

    return tempNode

}
