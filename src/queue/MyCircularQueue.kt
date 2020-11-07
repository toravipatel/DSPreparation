package queue

fun main() {

}

class MyCircularQueue(k: Int) {

    /** Initialize your data structure here. Set the size of the queue to be k. */

    var myQueue = IntArray(k)
    var head = -1
    var rear = -1

    init {
        myQueue.forEachIndexed { index, i ->
            myQueue[index] = -1
        }
    }


    /** Insert an element into the circular queue. Return true if the operation is successful. */
    fun enQueue(value: Int): Boolean {
        if(!isFull())
        {
            rear++
            myQueue[rear] = value
            return true
        }

        return false
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    fun deQueue(): Boolean {
        if(!isEmpty()){
            myQueue[head] = -1
            head--
            return true
        }
        return false
    }

    /** Get the front item from the queue. */
    fun Front(): Int {
        if(!isEmpty())
            return myQueue[head]

        return -1
    }

    /** Get the last item from the queue. */
    fun Rear(): Int {
        return myQueue[rear]
    }

    /** Checks whether the circular queue is empty or not. */
    fun isEmpty(): Boolean {
        return head == rear
    }

    /** Checks whether the circular queue is full or not. */
    fun isFull(): Boolean {

        return (head != null && myQueue[getNextSlot(rear)] != -1)
    }

    fun getNextSlot(position:Int):Int{

        if(position == myQueue.size-1)
            return 0

        return position+1

    }

}