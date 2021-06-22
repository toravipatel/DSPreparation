package array

fun maxIceCream(costs: Array<Int>, coins: Int): Int {

    val data = costs
    data.sort()
    var totalIceCream = 0
    var remainingCoin = coins
    data.forEach {

        if(it <= remainingCoin)
        {
            totalIceCream++
            remainingCoin = remainingCoin - it
        }


    }

    return totalIceCream

}

fun main() {
    println(maxIceCream(arrayOf(1,3,1,2,4),7))
}