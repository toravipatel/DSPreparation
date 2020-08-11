package stack

import java.util.*

fun main() {

    val s = ""
    println(isValid(s))

}

fun isValid(s: String): Boolean {

    var stringDataStack = Stack<Char>()

    if(s.isNullOrEmpty())
        return true

    s.forEach {

        if(it == '(' || it == '{' || it == '[')
            stringDataStack.push(it)
        else if(it == ')' || it == '}' || it == ']')
        {
            if(stringDataStack.isEmpty())
                return false

            var tempChar = stringDataStack.pop()

            if(!(it == ')' && tempChar == '(' || it == '}' && tempChar == '{' || it == ']' && tempChar == '[' ))
            {
                return false
            }

        }

    }


    return stringDataStack.isEmpty()
}