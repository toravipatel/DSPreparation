package heap

import java.util.*
import kotlin.collections.ArrayList

//https://leetcode.com/explore/learn/card/heap/646/practices/4088/

fun main() {

}

class Solution {

    data class PointNode(val distance:Int = 0, var point:IntArray)

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {

        var pointQueue = PriorityQueue<PointNode> {
                t1, t2 -> t2.distance - t1.distance
        }


        points.forEach{

            pointQueue.add(PointNode(getDistance(it), it))
            if(pointQueue.size > k)
                pointQueue.poll()

        }

        var result = ArrayList<IntArray>()
        pointQueue.forEachIndexed { index, pointNode ->
            result[index]= pointNode.point
        }

        var word = "test"
        for(i in 0..word.length-1){
            word.get(i)
        }

        return result.toTypedArray()
    }

    fun getDistance(points: IntArray):Int{
        return points[0] * points[0] + points[1] * points[1]
    }
}

class Trie() {

    data class TrieNode( var children:HashMap<Char,TrieNode> = HashMap(), var isWord:Boolean = false)
    var root:TrieNode = TrieNode()

    fun insert(word: String) {

        var current = root
        word.forEach{

            var isChildAvailable = current.children.get(it)

            if( isChildAvailable == null){
                current.children.put(it, TrieNode())
            }
            current = current.children.get(it)!!

        }
        current?.isWord = true


    }

    fun search(word: String): Boolean {

     return true

    }

}

fun startsWith(prefix: String): Boolean {
    return true
}




