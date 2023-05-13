package recursion

import java.lang.StringBuilder


fun main() {
findContestMatch(10)
}

// Iterative Approach
fun findContestMatch(n: Int): String {

    println(kotlin.math.log2(8.0).toInt())
    var finalLevel = kotlin.math.log2(8.0).toInt()
    contestGenerator(finalLevel, 1, StringBuilder("1").toString(), StringBuilder("$n").toString())
    return ""
}

fun contestGenerator(finalLevel:Int, currentLevel:Int, firstTeam:String, secondTeam:String){
    if(currentLevel == finalLevel){

        var resultString = "(".plus(firstTeam).plus(",").plus(secondTeam).plus(")")
        println(resultString)

    }

}