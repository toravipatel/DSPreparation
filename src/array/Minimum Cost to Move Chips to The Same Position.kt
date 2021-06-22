package array

fun main() {

}

fun minCostToMoveChips(position: IntArray): Int {

    var oddIndex = 0
    var evenIndex = 0

    position.forEach {

        if(it % 2 == 0 )
            evenIndex++
        else
            oddIndex++
    }

    return Math.min(evenIndex,oddIndex)
}