package leetcode.stringproblem

fun main() {
    var J = "aA"
    var S = "aAATRDFDFD"

    println(numJewelsInStones(J,S))
}



fun numJewelsInStones(J: String, S: String): Int {

    var map = HashMap<Char,Int>()

    var counter = 0

    S.forEach {char->

        if(map.containsKey(char)){

            var count:Int? = map.get(char)
            count?.let{
                map.put(char,++count)
            }
        }
        else{
            map.put(char,1)
        }
    }

    J.forEach {

        if(map.containsKey(it))
            counter += map.get(it)!!

    }

    return counter

}