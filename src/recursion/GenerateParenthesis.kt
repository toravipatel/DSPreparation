package recursion

fun main() {
    var n = 3
    generateParenthesis(3, 3, "")
}

fun generateParenthesis(openCount: Int, closedCount: Int, result: String) {

    if(openCount == 0 && closedCount == 0){
        println(result)
        return
    }

    if(openCount == closedCount){
        return generateParenthesis(openCount-1, closedCount, result.plus("("))
    }else{
        if(openCount == 0)
            return generateParenthesis(openCount, closedCount-1, result.plus(")"))
        else{
            generateParenthesis(openCount-1, closedCount , result.plus("("))
            generateParenthesis(openCount, closedCount-1 , result.plus(")"))
            return
        }
    }

    return

}
