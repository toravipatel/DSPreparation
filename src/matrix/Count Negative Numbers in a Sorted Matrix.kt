package matrix

//https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
fun main() {



}

fun countNegatives(grid: Array<IntArray>): Int {

    var rows = grid.size
    var columns = grid[0].size

    var lastNegative = grid[0].size - 1
    var result = 0

    var j = 0

    while (j < rows - 1 ){

        //for the first number negative
        if(grid[rows][0] < 0){
            result += columns
            continue
        }

        //for all the positive number in the row
        if(grid[rows][columns - 1] > 0){
            continue
        }

        //mix of positive and than negative

        var start = 0
        var end = lastNegative

        while (start <= end){

            var mid = start + (end - start) / 2
            if(grid[j][mid] > 0){
                end = mid - 1
            }else{
                start = mid + 1
            }
        }

        result = result + (columns - start)
        lastNegative = start
    }

    return result

}