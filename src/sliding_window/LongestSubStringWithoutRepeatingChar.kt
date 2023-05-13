package sliding_window


fun main() {
    println(lengthOfLongestSubstringData("pwwkew"))
}

fun isAllCharUniqueString(charMap:HashMap<Char,Int>):Boolean{

    var temp:HashMap<Char,Int> = charMap.clone() as HashMap<Char, Int>

    var result = true
    charMap.forEach { t, u ->

        if(u > 1)
            result = false
    }

    return result

}


fun lengthOfLongestSubstringData(s: String): Int {

    var ans = 0
    var i = 0
    var j = 0
    var size = s.length
    var charMap = HashMap<Char,Int>()

    var maxLength = Int.MIN_VALUE

    while (j < size){

        var fr = charMap.getOrDefault(s[j],0)
        charMap.put(s[j],++fr)

        if(isAllCharUniqueString(charMap)){
            maxLength = Math.max(maxLength, j-i+1)
        }
        else{

            var charFr = charMap.getOrDefault(s[i],0)
            if(charFr > 1)
                charMap[s[i]] = --charFr
            else
                charMap.remove(s[i])

            i++
        }

        j++
    }

    return maxLength
}

