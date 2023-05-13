package sliding_window

//https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/
fun main() {

    println(numKLenSubstrNoRepeats("havefunonleetcode",5))
}

fun numKLenSubstrNoRepeats(s: String, k: Int): Int {

    var i = 0
    var j = 0
    var size = s.length
    var charMap = HashMap<Char,Int>()

    var count = 0
    while (j < size){

        var getFrq = charMap.getOrDefault(s[j],0)
        charMap.put(s[j],++getFrq)

        if(j-i+1 < k){
            j++
        }else if(j-i+1 == k){

            if(isAllCharUnique(charMap))
                count++

            var frq = charMap.getOrDefault(s[i],0)
            if(frq == 1)
                charMap.remove(s[i])
            else
                charMap.put(s[i],--frq)

            i++
            j++

        }

    }

    return count
}

fun isAllCharUnique(charMap:HashMap<Char,Int>):Boolean{

    var isAllUnique = true

    var s = ":Tst"
    var data = charMap.get(s[0])

    charMap.forEach { t, u ->
        if(u > 1)
            isAllUnique = false
    }

    return isAllUnique
}