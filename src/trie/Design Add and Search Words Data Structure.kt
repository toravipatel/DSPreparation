package trie

import java.util.*
import kotlin.collections.HashMap

//https://leetcode.com/problems/design-add-and-search-words-data-structure/
fun main() {

    var s = "."
    println(s.substring(1))
}

class WordDictionary() {

    val rootNode = TrieNodeData()
    init {

    }

    var arr = arrayOfNulls<Int>(5)



    fun addWord(word: String) {

        var data = rootNode.children.keys
        //data.forEach {  }
        var node = rootNode
        word.forEach {

            if(!node.children.containsKey(it)){
                node.children[it] = TrieNodeData()
            }

            node = node.children[it]!!
        }

        node.isWord = true

    }

    fun search(word: String): Boolean {

        var node = rootNode
        word.forEachIndexed { index, value ->

            if(!node.children.containsKey(value)){

                println("current char is $node")


                if(value == '.'){

                    var allNodes = node.children.keys
                    allNodes.forEach {

                        var childNode = node.children.get(it)
                        //if(search(word.substring(index+1),childNode))

                    }

                }

               return false
            }

            //node = node.children[it]!!
        }

        return node.isWord
    }

}

fun minOperations(nums1: IntArray, nums2: IntArray, k: Int): Long {

    if(k ==0)
    {
        if(Arrays.equals(nums1,nums2))
            return 0
        else
            return -1
    }

    var up = 0
    var down = 0

    for (i in 0..nums1.size-1){

        var difference = Math.abs(nums1[i] - nums2[i])
        if(difference == 0)
            continue

        var reminder = difference % k

        if(reminder != 0)
            return -1
        else{

            if(nums1[i] > nums2[i])
                down = down + difference/k
            else
                up = up + difference/k

        }
    }

    if(up == down)
        return up.toLong()
    else
        -1


    return -1
}

data class TrieNodeData(val children: HashMap<Char,TrieNodeData> = HashMap(),var isWord:Boolean = false)