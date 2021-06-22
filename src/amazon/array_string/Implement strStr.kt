package amazon.array_string

class `Implement strStr` {
}

fun main() {

}

fun strStr(haystack: String, needle: String): Int {

    if(haystack.length < needle.length)
        return -1

    var windowSize = needle.length
    var start = 0
    var end = start + needle.length
    var needleMap = HashMap<Char,Int>()
    needle.forEach {

        val currentFrequency = needleMap.getOrDefault(it,0)
        needleMap.put(it,currentFrequency+1)
    }

    while (start < haystack.length - windowSize){

       // if(checkSubStringMatchNeedle())


    }



    return 0
}

fun checkSubStringMatchNeedle(charMap:HashMap<Char,Int>, subString:String):Boolean{

    subString.forEach {

        if(charMap.containsKey(it))
            charMap.remove(it)
        else
            return false

    }

    return charMap.isEmpty()
}