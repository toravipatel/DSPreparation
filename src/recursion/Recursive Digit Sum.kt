package recursion

class `Recursive Digit Sum` {


}

fun main() {

    println(superDigit("98",3))
}

// Complete the superDigit function below.
fun superDigit(n: String, k: Int): Int {


    var finalNumber = ""
    for (i in 0..k-1){
        finalNumber = finalNumber.plus(n)
    }

    return getSuperDigit(finalNumber.toInt())

}

fun getSuperDigit(number: Int): Int {

    if(number<10)
        return number

    var sum  = 0
    var tempNum = number

    while (tempNum>0){

        var reminder = tempNum%10
        tempNum /= 10
        sum += reminder

    }

    return getSuperDigit(sum)

}
