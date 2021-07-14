package trie

import java.util.*
import kotlin.collections.HashMap

class TrieNode<Key>(var key:Key?,  var parent:TrieNode<Key>?){
    val children: HashMap<Key, TrieNode<Key>> = HashMap()
    var isTerminating = false
}

class Trie<Key>{

    private val root = TrieNode<Key>(key = null , parent =  null)

    fun insert(list:List<Key>){

        var current = root

        list.forEach { element ->
            if(current.children[element] == null){
                current.children[element] = TrieNode(element, current)
            }
            current = current.children[element]!!
        }
        current.isTerminating = true
    }

    fun collection(prefix:List<Key>): List<List<Key>>{

        var current = root

        prefix.forEach {
            element ->

            val child = current.children[element] ?: return emptyList()
            current = child

        }
        return collections(prefix, current)
    }

    private fun collections(prefix:List<Key>, node:TrieNode<Key>?):List<List<Key>>{

        val results = mutableListOf<List<Key>>()

        if(node?.isTerminating!!){
            results.add(prefix)
        }

        node?.children?.forEach { (key,node) ->

            results.addAll(collections(prefix+key, node))
        }

        return  results
    }
}
