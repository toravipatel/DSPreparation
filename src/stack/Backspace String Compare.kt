package stack

import java.util.*

fun main() {

    var S = "a#c"
    var T = "b"

    println(backspaceCompare(S,T))

}

fun backspaceCompare(S: String, T: String): Boolean {


    var stackOne = Stack<Char>()
    var stackTwo = Stack<Char>()

    S.forEach {

        if(it == '#' && !stackOne.isEmpty())
            stackOne.pop()
        else
            stackOne.push(it)
    }

    T.forEach {

        if(it == '#' && !stackTwo.isEmpty())
            stackTwo.pop()
        else
            stackTwo.push(it)
    }


    if(stackOne.size != stackTwo.size)
        return false
    else{

        while(!stackOne.isEmpty()){
            if (stackOne.pop() == stackTwo.pop())
                continue
            else
                return false
        }

    }

    return stackOne.isEmpty() && stackTwo.isEmpty()
}