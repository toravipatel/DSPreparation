package queue

fun main() {

}


fun numIslands(grid: Array<CharArray>): Int {

    var totalIsland = 0

    for (i in 0..grid.size-1){
        for(j in 0..grid[i].size-1){
            if(grid[i][j] == '1'){
                totalIsland++
                totalIslandDFS(grid,i,j)
            }
        }
    }
    return totalIsland
}

//DFS approach
/*fun numIslands(grid: Array<CharArray>): Int {

    var totalIsland = 0

    for (i in 0..grid.size){
        for(j in 0..grid[i].size){
            if(grid[i][j] == '1'){
                totalIsland++
                totalIslandDFS(grid,i,j)
            }
        }
    }
    return totalIsland
}*/

fun totalIslandDFS(grid: Array<CharArray>, row:Int, column:Int){

    var nr = grid.size
    var nc = grid[0].size

    if(row < 0 || column < 0 || row >= nr || column >= nc || grid[row][column]=='0')
        return

    grid[row][column] = '0'

    totalIslandDFS(grid,row+1,column)
    totalIslandDFS(grid,row-1,column)
    totalIslandDFS(grid,row,column+1)
    totalIslandDFS(grid,row,column-1)

}