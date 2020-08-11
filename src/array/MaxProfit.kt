package array

fun main() {

    var data= intArrayOf(7,1,5,6,3,4)
    println(maxProfit(data))
}

fun maxProfit(prices: IntArray): Int {

    var minPrize =Int.MAX_VALUE
    var maxProfit = 0

    prices.forEachIndexed { index, i ->

        if(i<minPrize)
            minPrize = i
        else if(i-minPrize>maxProfit)
            maxProfit = i- minPrize

    }
    return maxProfit
}

