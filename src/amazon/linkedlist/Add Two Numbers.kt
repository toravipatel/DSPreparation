package amazon.linkedlist


class ListNode(var `val`: Int) {
         var next: ListNode? = null
}
fun main() {

}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    var l1Current = l1
    var l2Current = l2
    var resultCurrent:ListNode = ListNode(0)
    var resultHead:ListNode? = resultCurrent
    var reminder = 0
    while (l1Current != null || l2Current != null){

        var sum = l1Current!!.`val`+ l2Current!!.`val` + reminder
        var resultNode = ListNode(sum % 10)
        resultCurrent.next= resultNode
        resultCurrent = resultCurrent.next!!
        reminder = sum / 10

        l1Current = l1Current!!.next
        l2Current = l2Current!!.next

    }

    while (l1Current != null){
        var resultNode = ListNode(l1Current!!.`val`)
        resultCurrent= resultNode
        resultCurrent = resultCurrent.next!!

        l1Current = l1Current!!.next
    }

    while (l2Current != null){
        var resultNode = ListNode(l1Current!!.`val`)
        resultCurrent= resultNode
        resultCurrent = resultCurrent.next!!

        l1Current = l1Current!!.next
    }


    return resultHead
}