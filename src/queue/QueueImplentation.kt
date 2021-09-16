package queue

fun main() {

    var queueManager = MyCircularQueueImpl(6)
    queueManager.enQueue(6)
    println(queueManager.Rear())
    println(queueManager.Rear())
    queueManager.deQueue()
    queueManager.enQueue(5)
    println(queueManager.Rear())
    queueManager.deQueue()

}

class MyCircularQueueImpl(var k: Int) {

    var queue: IntArray = IntArray(k)
    var front = -1
    var rear = -1

    fun enQueue(value: Int): Boolean {

        if(isFull())
            return false
        else if(front == -1 && rear == -1){
            front = 0
            rear = 0
            queue[rear] = value
            return true
        }
        else {
            rear = (rear + 1)% k
            queue[rear] = value
            return true
        }

    }

    fun deQueue(): Boolean {
        if(isEmpty())
            return false
        else if(front == rear ){
            front = -1
            rear = -1
            return true
        }
        else{
            front = (front + 1) % k
            return true
        }
    }

    fun Front(): Int {
        if(isEmpty())
            return -1

        return queue[front]
    }

    fun Rear(): Int {
        if(isEmpty())
            return -1

        return queue[rear]
    }

    fun isEmpty(): Boolean {
        return front == -1 && rear == -1
    }

    fun isFull(): Boolean {

        return (rear + 1) % k == front

    }

}