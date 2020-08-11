package leetcode.stringproblem

fun main() {

    var data = ArrayList<Int>()

    data.add(-8)
    data.add(5)
    data.add(-2)
    data.add(3)
    data.add(7)
    data.add(9)
    data.add(3)

    sortedSquares(data.toIntArray()).forEach {

        println(it)
    }
}

fun sortedSquares(A: IntArray): IntArray {

    A.forEachIndexed { index, i ->
        A[index] = i*i
    }

    return A.sortedArray()

}