package sliding_window

//https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
fun main() {

    println(lengthOfLongestSubstringTwoDistinct("ccaabbb"))
}

fun lengthOfLongestSubstringTwoDistinct(s: String): Int {

    var i = 0
    var j = 0
    var size = s.length

    var charMap = HashMap<Char, Int>()
    var uniqueCharLength = 2

    var maxLength = Int.MIN_VALUE
    while (j < size) {

        var getCharFrq = charMap.getOrDefault(s[j], 0)
        charMap.put(s[j], ++getCharFrq)

        if (charMap.size == uniqueCharLength) {
            maxLength = Math.max(maxLength, j - i + 1)
            j++

        } else if (charMap.size > uniqueCharLength) {
            var frq = charMap.getOrDefault(s[i], 0)
            if (frq == 1)
                charMap.remove(s[i])
            else
                charMap.put(s[i], --frq)

            i++
            j++
        } else {
            j++
        }

    }

    return maxLength
}

fun isValidString(charMap: HashMap<Char, Int>, distinctSize: Int): Boolean {
    return charMap.size == distinctSize
}