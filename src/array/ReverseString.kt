package array

fun reverseString(s: CharArray): Unit {

    var start = 0
    var end = s.size-1

    while(start <= end){

        var temp = s[start]
        s[start] = s[end]
        s[end] = temp


    }


}