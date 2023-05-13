package unique_problem

import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

//https://leetcode.com/problems/design-tic-tac-toe/description/
fun main() {


    var ticTacToe = TicTacToe(2)
    println(ticTacToe.move(0,1,1))
    println(ticTacToe.move(1,1,2))
    println(ticTacToe.move(1,0,1))
    var list = ArrayList<Int>()

    println("------------")

    println(Random.nextInt(100))
    Random(list.size).nextInt(100)
    (0..10).random()


}

class TicTacToe(n: Int) {

    /** Initialize your data structure here. */

    var rowMove = arrayOfNulls<Int>(n)
    var columnMove = arrayOfNulls<Int>(n)

    var diagonalMove = 0
    var antidiagonalMove = 0

    var size = n


    init {
        for (i in 0 until n){
            rowMove[i] = 0
            columnMove[i] = 0
            //diagonalMove[i] = 0
            //antidiagonalMove[i] = 0
        }
    }


    /** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
    0: No one wins.
    1: Player 1 wins.
    2: Player 2 wins. */
    fun move(row: Int, col: Int, player: Int): Int {

        if(player == 1){
            rowMove[row] = rowMove[row]!! + 1
            columnMove[col] = columnMove[col]!! + 1

            if(row == col)
                diagonalMove++

            if(col == size-row-1)
                antidiagonalMove++
        }
        else{
            rowMove[row] = rowMove[row]!! - 1
            columnMove[col] = columnMove[col]!! - 1

            if(row == col)
                diagonalMove--

            if(col == size-row+1)
                antidiagonalMove--
        }

        if(isPlayerWinner(player))
            return player
        else
            return 0

    }

    private fun isPlayerWinner(player:Int):Boolean{

        var searchValue = if(player == 1) size else size*(-1)

        for (i in 0..size-1){
            if(rowMove[i] == searchValue || columnMove[i] == searchValue)
                return true
        }

        return (diagonalMove==searchValue || antidiagonalMove == searchValue)

    }

}