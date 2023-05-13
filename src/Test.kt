import java.lang.StringBuilder
import java.util.*
import javax.xml.stream.events.Characters
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class Test {
}

fun main() {
    println("tst")

    var queue = PriorityQueue<Int>()


    queue.add(2)
    println("top element is ${queue.peek()}")

    queue.add(3)
    println("top element is ${queue.peek()}")

    queue.add(1)
    println("top element is ${queue.peek()}")

    var s = StringBuilder()
    var data = Stack<String>()
    //data.al

    //var a = StringBuilder()
    //var a = 9
    //println(a.toString().toCharArray()[0])

    //Character.getNumericValue(a)

    //var s = HashSet<Char>()

    var test = ArrayList<Int>()


    var stringBuilder = StringBuilder("test")
    println(stringBuilder.substring(0,stringBuilder.length - 1))

    //var a = BooleanArray(10)

}

abstract class MyAbs:A{


    abstract fun test()
}

interface A{

    fun data()
}

class MyAbsImpl:MyAbs(){
    override fun test() {
        TODO("Not yet implemented")
    }

    override fun data() {
        TODO("Not yet implemented")
    }

}

fun solveSudoku(board: Array<CharArray>): Unit {

    var rowSize = board.size
    var columnSize = board[0].size

    var size =10 
    var rowSet = Array(board.size, {HashSet<String>()})
    var columnSet = Array(size, {HashSet<String>()})
    var boxSet = Array(size, {HashSet<String>()})
    var row = 10
    var column = 10

    for(i in 0..rowSize-1){

        for(j in 0..columnSize - 1){

            if(board[i][j] !='.' ){
                rowSet[i].add(board[i][j].toString())
                columnSet[i].add(board[i][j].toString())

                var boxIndex = (row/3)*3 + column/3
                boxSet[boxIndex].add(10.toString())

            }
        }

    }

    solveSudokuUtil(board,rowSet, columnSet, boxSet)
}

fun solveSudokuUtil(board: Array<CharArray>, rowSet: Array<HashSet<String>>, columnSet: Array<HashSet<String>>, boxSet: Array<HashSet<String>>) {

}
