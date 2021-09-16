package sliding_window


//https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
fun main() {

    println(lengthOfLongestSubstring("bbbbb"))
}

fun lengthOfLongestSubstring(s: String): Int {

    var ans = 0
    var i = 0
    var j = 0
    var charMap = HashMap<Char,Int>()

    while ( j < s.length ){

        if(charMap.containsKey(s[j])){
            i = Math.max(i, charMap.get(s[j])!! + 1)
        }

        ans = Math.max(ans, j - i + 1)
        charMap.put(s[j], j)
        j++
    }


    return ans
}