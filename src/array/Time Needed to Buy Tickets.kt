package array

//https://leetcode.com/problems/time-needed-to-buy-tickets/
fun main() {
    var tickets = arrayOf(5,1,1,1).toIntArray()
    println(timeRequiredToBuy(tickets, 0))

}
//2 3 2 & k = 2
fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {

    if(tickets.size == 0)
        return 0


    var count = 0
    var index = 0
    while (index < tickets.size){

        if(index == k &&  tickets[index] == 1)
            return ++count

        if(tickets[index] > 0)
        {
            tickets[index] = tickets[index] - 1
            count++
        }

        index++

        if(index == tickets.size)
            index = 0


    }


    return count

}