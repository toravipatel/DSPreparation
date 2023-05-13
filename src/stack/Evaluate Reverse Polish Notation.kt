package stack

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
fun main() {

    var data = ArrayList<String>()
    data.add("1")
    data.add("2")
    data.add("+")
    data.add("3")
    data.add("*")

}

fun getLastTwoNumber(stack:Stack<String>): List<Int> {

    var lastNumber = stack.pop().toInt()
    var secondLastNumber = stack.pop().toInt()

    return arrayListOf(secondLastNumber,lastNumber).toList()

}

fun evalRPN(tokens: Array<String>): Int {

    var resultStack = Stack<String>()

    tokens.forEachIndexed { index, s ->


        with(s) {
            when {
                equals("*") -> {

                    var list = getLastTwoNumber(resultStack)
                    var newResult = list[0] * list[1]
                    resultStack.push(newResult.toString())
                }
                equals("/") -> {

                    var list = getLastTwoNumber(resultStack)
                    var newResult = list[0] / list[1]
                    resultStack.push(newResult.toString())

                }
                equals("+") -> {
                    var list = getLastTwoNumber(resultStack)
                    var newResult = list[0] + list[1]
                    resultStack.push(newResult.toString())
                }
                equals("-") -> {
                    var list = getLastTwoNumber(resultStack)
                    var newResult = list[0] - list[1]
                    resultStack.push(newResult.toString())
                }
                else -> resultStack.push(s)
            }
        }


    }


    return resultStack.pop().toInt()
}

