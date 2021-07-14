package walmart.easy

fun main() {

}

fun isAlienSorted(words: Array<String>, order: String): Boolean {

    val charMap = HashMap<Char,Int>()
    order.forEachIndexed { index, c ->
        charMap.put(c,index)
    }

    for (i in 0..words.size){

    }

    return true
}