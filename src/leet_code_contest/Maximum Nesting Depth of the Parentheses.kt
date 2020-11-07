package leet_code_contest

import java.util.*

fun maxDepth(s: String): Int {

    var stringDataStack = Stack<Char>()
    var maxDepth = Int.MIN_VALUE

    if(s.isNullOrEmpty())
        return 0

    for (i in 0..s.length-1)
    {

        var stringDataStack = Stack<Char>()
        var maxDepth = Int.MIN_VALUE

        if(s.isNullOrEmpty())
            return 0

        for (i in 0..s.length-1)
        {

            if(s[i] == '(' || s[i] == '{' || s[i] == '[')
            {
                stringDataStack.push(s[i])
                if(stringDataStack.size > maxDepth)
                    maxDepth = stringDataStack.size
            }
            else if(s[i] == ')' || s[i] == '}' || s[i] == ']')
            {
                if(stringDataStack.isEmpty())
                    break

                stringDataStack.pop()
            }

        }


        return if(maxDepth == Int.MIN_VALUE) stringDataStack.size else maxDepth
        if(s[i] == '(' || s[i] == '{' || s[i] == '[')
        {
            stringDataStack.push(s[i])
            if(stringDataStack.size > maxDepth)
                maxDepth = stringDataStack.size
        }
        else if(s[i] == ')' || s[i] == '}' || s[i] == ']')
        {
            if(stringDataStack.isEmpty())
                break

            stringDataStack.pop()
        }

    }


    return if(maxDepth == Int.MIN_VALUE) stringDataStack.size else maxDepth

}

fun main() {

    println(maxDepth("1"))
    //Collections


}