package leetcode.stringproblem

// https://leetcode.com/problems/is-subsequence/

fun main() {

}

fun isSubsequence(s: String, t: String): Boolean {

    var leftBound = s.length
    var rightBound = t.length

    var left = 0
    var right = 0

    var result = false

    while (left < leftBound && right < rightBound){

        if(s[left] == t[right]){
            left++
            right++
        }else
            right++
    }

    return left >= leftBound
}