package sliding_window

fun main() {

    println(countGoodSubstrings("aababcabc"))
}

fun countGoodSubstrings(s: String): Int {

    var start = 0
    var end = 2
    var charSet = HashSet<Char>()
    var result = 0

    for (i in 0..s.length - 1 - 3){


            charSet.clear()

            var j = i
            end = j+2
            while (j <= end){
                if(!charSet.contains(s[j]))
                    charSet.add(s[j])
                else
                    break

                j++
            }

            if(charSet.size == 3)
                result++


            start++
            end++
    }



    return result
}