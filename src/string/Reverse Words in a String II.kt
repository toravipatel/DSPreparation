package string


//https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3806/
fun main() {

    var sentence = "we have tea".toCharArray()
    reverseWords(sentence)
    sentence.forEach {
        print(it)
    }

}

fun reverseWords(s: CharArray): Unit {

    var start = 0
    var end = s.size - 1

    // reversing the whole array first
    while (start < end){

        var temp = s[start]
        s[start] = s[end]
        s[end] = temp

        start++
        end--
    }

    //reversing the each word

    var startIndex = 0
    var wordIndex = 0

    while (wordIndex < s.size){

        while ( wordIndex+1 != s.size &&  s[wordIndex + 1] != ' '){
            wordIndex++
        }

        var tempWordIndex = wordIndex

        //swap each word
        while (startIndex < wordIndex){
            var temp = s[startIndex]
            s[startIndex] = s[wordIndex]
            s[wordIndex] = temp

            startIndex++
            wordIndex--
        }

        wordIndex = tempWordIndex + 2
        startIndex = wordIndex
    }

}