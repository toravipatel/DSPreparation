package amazon.linkedlist

fun main() {

}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

    var currentL1 = l1
    var currentL2 = l2
    val resultHead: ListNode? = ListNode(-1)
    var current = resultHead

    while (currentL1 != null && currentL2 != null) {

        if (currentL1!!.`val` > currentL2!!.`val`) {
            var temp = ListNode(currentL1!!.`val`)
            current!!.next = temp
            current = current.next

            currentL1 = currentL1!!.next

        } else {
            var temp = ListNode(currentL2!!.`val`)
            current!!.next = temp
            current = current.next

            currentL2 = currentL2!!.next

        }
    }

    while (currentL1 != null){
        var temp = ListNode(currentL1!!.`val`)
        current!!.next = temp
        current = current.next

    }

    while (currentL2 != null){
        var temp = ListNode(currentL2!!.`val`)
        current!!.next = temp
        current = current.next
    }

    return resultHead!!.next

}