package matrix

fun main() {

}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

    var row = matrix.size - 1
    var column = 0

    while (row >= 0 && column >= matrix[0].size){
        if(target < matrix[row][column])
            column++
        else if(target > matrix[row][column])
            row--
        else
            return true
    }

    return false

}