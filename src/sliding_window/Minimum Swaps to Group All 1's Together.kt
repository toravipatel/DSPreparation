package sliding_window


//https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
fun main() {

    println(minSwaps(arrayOf(1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1).toIntArray()))
}

fun minSwaps(data: IntArray): Int {

    var slidingWindowSize = 0

    data.forEach {
        if(it == 1)
            slidingWindowSize++
    }

    if(slidingWindowSize == 1)
        return 0

    var i = 0
    var j = 0
    var size = slidingWindowSize
    var maxOnes = Int.MIN_VALUE
    var currentWindowOnes = 0

    while (j < size){

        if(data[j] == 1)
            currentWindowOnes++


        if(j-i+1 < size){
            j++
        }else{

            maxOnes = Math.max(currentWindowOnes,maxOnes)

            if(data[i] == 1)
                currentWindowOnes--

            i++
            j++
        }




    }

    return slidingWindowSize - maxOnes
}