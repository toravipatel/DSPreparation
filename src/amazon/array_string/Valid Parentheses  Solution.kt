package amazon.array_string

import java.util.*

fun main() {

    println(isValid("()[]{}"))
}
fun isValid(s: String): Boolean {

    val bracketStack = Stack<Char>()

    s.forEach {

        when (it) {
            '(' -> {
                bracketStack.push(it)
            }
            '{' -> {
                bracketStack.push(it)
            }
            '[' -> {
                bracketStack.push(it)
            }
            ')' ->{
                if(bracketStack.isEmpty())
                    return false

                if(bracketStack.pop() != '(')
                    return false

            }
            '}' ->{
                if(bracketStack.isEmpty())
                    return false

                if(bracketStack.pop() != '}')
                    return false
            }
            ']' ->{
                if(bracketStack.isEmpty())
                    return false

                if(bracketStack.pop() != ']')
                    return false
            }
        }


    }



    return bracketStack.isEmpty()
}