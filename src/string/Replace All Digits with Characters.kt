package string

//https://leetcode.com/problems/replace-all-digits-with-characters/
fun main() {


    //println(replaceDigits("a1b2c3d4e"))
    println(reversePrefix("abcdefd",'d'))

}

fun reversePrefix(word: String, ch: Char): String {



    var firstCharPointer = 0
    var wordData:StringBuilder = StringBuilder(word)

    var i = 0

    while(i < wordData.length){

        if(wordData[i] == ch){
            firstCharPointer = i
            break
        }
        i++
    }

    var startPointer = 0
    var endPointer = firstCharPointer

    while(startPointer < endPointer){

        var temp = wordData[startPointer]
        wordData[startPointer] = wordData[endPointer]
        wordData[endPointer] = temp

        startPointer++
        endPointer--

    }

    return wordData.toString()

}

fun replaceDigits(s: String): String {

    var resultBuilder = s.toCharArray()
    var shiftPointer = 1

    while(shiftPointer < resultBuilder.size)
    {
        resultBuilder[shiftPointer] = (resultBuilder[shiftPointer-1] + resultBuilder[shiftPointer].toInt()  - '0').toChar()
        shiftPointer += 2
    }

    return String(resultBuilder)
}