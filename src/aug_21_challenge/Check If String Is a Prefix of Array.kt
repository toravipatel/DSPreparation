package aug_21_challenge

fun main() {

    println(isPrefixString("iloveleetcode",ArrayList<String>().apply {
        add("apples")
        add("i")
        add("love")
        add("leetcode")
    }.toTypedArray()))

}


fun isPrefixString(s: String, words: Array<String>): Boolean {

    var currentSubString = ""

    words.forEach {

        currentSubString += it
        if(currentSubString.equals(s))
            return true
        else if(!s.contains(currentSubString))
            return false


    }


    return currentSubString.equals(s)
}