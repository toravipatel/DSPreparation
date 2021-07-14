package walmart.easy

import java.util.*
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap

class LRUCache(capacity: Int) {

    var lruMap = LinkedHashMap<Int,Int>(capacity)
    var lruQueue = LinkedList<Int>()

    fun get(key: Int): Int {

        if(lruMap.contains(key)) {
            lruQueue.addFirst(key)
            return lruMap.get(key)!!
        }
        return -1
    }

    fun put(key: Int, value: Int) {

        if(!lruMap.containsKey(key)){
            lruMap.put(key,value)
        }
        lruQueue.addFirst(key)

    }

}