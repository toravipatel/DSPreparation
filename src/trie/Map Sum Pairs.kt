package trie

// https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1058/
fun main() {

}

data class TrieN(var children:HashMap<Char,TrieN> = HashMap() ,var isWord:Boolean = false , var value:Int = 0)


class MapSum() {

    var root = TrieN()
    var wordMap = HashMap<String,Int>()

    fun insert(key: String, `val`: Int) {

        var valueToAdd = `val`
        if(wordMap.containsKey(key)){
            var getExistingValue = wordMap.getOrDefault(key, 0)
            valueToAdd = `val` - getExistingValue
        }

        var current = root
        key.forEach {

            var isChildAvailable = current.children?.get(it)
            if(isChildAvailable == null){
                current.children?.put(it, TrieN(value = valueToAdd))
            }else{
                var curValue = current.children.get(it)!!.value
                current.children.get(it)!!.value = curValue + valueToAdd
            }

            current = current.children.get(it)!!
        }
        wordMap.put(key, `val`)
    }

    fun sum(prefix: String): Int {

        var current = root
        var sum = 0

        prefix.forEach {

            if (current.children?.containsKey(it)!!){
                current = current.children?.get(it)!!
            }
            else
                return -1

        }

        return current.value
    }

}