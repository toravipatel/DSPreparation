package linkedlist

import java.util.*
import kotlin.collections.HashSet

fun main() {

}

class MRUQueue(n: Int) {

    var list:LinkedList<Int> = LinkedList<Int>()
    lateinit var dataSet:HashSet<Int>

    init {

        dataSet = HashSet<Int>(n)

    }

    fun initQueueData(n: Int){

        for (i in 0..n-1){
            list.add(i)
        }
    }

    fun fetch(k: Int): Int {

        return 0
    }

}