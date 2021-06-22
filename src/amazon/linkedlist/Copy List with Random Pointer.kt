package amazon.linkedlist


class Node(var `val`: Int) {
         var next: Node? = null
         var random: Node? = null
     }

fun main() {

}

class CopyLinkedListManager {

    val nodeMap = HashMap<Node,Node>()

    fun getClonedNode(node: Node?): Node? {

        if (node == null)
            return null

        return if(nodeMap.contains(node))
            nodeMap.get(node)
        else {
            val newNode = Node(node.`val`)
            nodeMap[node] = newNode
            newNode
        }
    }

    fun copyRandomList(node: Node?): Node? {

        if(node == null)
            return null

        var temp = node
        val clonedHead = Node(node.`val`)
        nodeMap[temp] = clonedHead
        while (temp != null){

            var curr = getClonedNode(temp)
            curr?.next = getClonedNode(temp.next)
            curr?.random = getClonedNode(temp.random)

            temp = temp.next
        }


        return nodeMap[node]
    }

    fun copyRandomListO1Space(node: Node?): Node? {

        if(node == null)
            return null

        var temp = node
        while (temp != null){

            var cloneNode = Node(node.`val`)
            var tempNext = temp.next
            cloneNode.next = tempNext
            temp.next = cloneNode
            temp = temp.next!!.next

        }

        var randomTemp = node
        while (randomTemp != null){

            var cloneNode = randomTemp.next
            cloneNode!!.random = randomTemp.random?.next
            randomTemp = cloneNode.next

        }

        var finalTemp = node
        var cloneHead = finalTemp.next

        while (finalTemp != null){


            var clone = finalTemp.next
            finalTemp.next = finalTemp.next?.next
            finalTemp = clone

        }


        return cloneHead
    }
}