package stackqueue

import java.util.*

// Complete the isBalanced function below.
fun isBalanced(s: String): String {


    val roundStartBracket = '('
    val curlyStartBracket = '{'
    val squareStartBracket = '['

    val roundEndBracket = ')'
    val curlyEndBracket = '}'
    val squareEndBracket = ']'

    val stack = Stack<Char>()


    s.forEach {


        if(it == (roundStartBracket) || it.equals(curlyStartBracket) || it.equals(squareStartBracket))
            stack.push(it)
        else{

            if(
                !stack.isEmpty() &&

                    ((it.equals(roundEndBracket) &&  (stack.lastElement() == roundStartBracket)) ||
                    (it.equals(curlyEndBracket) &&  (stack.lastElement() == curlyStartBracket)) ||
                    (it.equals(squareEndBracket) &&  (stack.lastElement() == squareStartBracket)))
            )
                stack.pop()
            else
            {
                return "NO"
            }
        }
    }

return if(stack.isEmpty())
         "YES"
    else
        "NO"

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val s = scan.nextLine()

        val result = isBalanced(s)

        println(result)
    }
}