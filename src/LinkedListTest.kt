import java.util.*

class LinkedListTest {




}

fun main() {

    var linkedListManager = LinkedListManager()
    //linkedListManager.addNode(1)
    linkedListManager.addNode(2)
    linkedListManager.printLinkedListData()

    linkedListManager.addNode(4)
    println("\n------------------------")
    linkedListManager.printLinkedListData()

    linkedListManager.addInSortedList(3)
    println("\n------------------------")
    linkedListManager.printLinkedListData()

    linkedListManager.addInSortedList(5)
    println("\n------------------------")
    linkedListManager.printLinkedListData()

    linkedListManager.addInSortedList(1)
    println("\n------------------------")
    linkedListManager.printLinkedListData()


}


class LinkedListManager{

    var head:Node?
    var tail:Node?

    init {
        head  = null
        tail = null

        head = tail
    }



    fun reverseLinkedList(){


      /*  if(head != null){

            var tempNode = head

            while (tempNode.nextNode != null){
                tempNode = tempNode.nextNode
            }


            head = tempNode



        }
*/


    }

    fun addInSortedList(newvalue: Int){
        var newNode = Node(newvalue)

        if(head == null){

            newNode.previousNode = null
            head = newNode
            newNode.nextNode = null

        }
        else{

            var tempNode = head

            while (tempNode?.nextNode != null){

                if(tempNode?.value < newvalue && tempNode?.nextNode?.value!! > newvalue)
                {
                    break
                }
                else
                    tempNode= tempNode?.nextNode


            }


            newNode.nextNode = tempNode?.nextNode
            newNode.previousNode = tempNode
            tempNode?.nextNode = newNode



        }
    }

    fun addNode(newvalue:Int){


        var newNode = Node(newvalue)

        if(head == null){

            newNode.previousNode = null
            head = newNode
            newNode.nextNode = null

        }
        else{

            var tempNode = head

            while (tempNode?.nextNode != null){

                tempNode= tempNode?.nextNode
            }

            tempNode?.nextNode = newNode
            newNode.previousNode = tempNode
            newNode.nextNode = null

        }
    }


    fun printLinkedListData(){

        if(head != null){

            var tempNode = head

            while (tempNode!= null){

                print("${tempNode.value} ->")
                tempNode = tempNode.nextNode
            }
        }
        else
            println("Linked list is empty.")
    }




}

data class Node(val value:Int, var previousNode: Node? = null, var nextNode:Node? = null)