package other_challenge

fun main() {
    val n = readLine()!!.trim().toInt()

    val s = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val dm = readLine()!!.trimEnd().split(" ")

    val d = dm[0].toInt()

    val m = dm[1].toInt()

    val result = birthday(s, d, m)

    println(result)

}

// Complete the birthday function below.
fun birthday(s: Array<Int>, d: Int, m: Int): Int {

    var counter = 0


    for (i in 0..(s.size-m)){

        var sum = 0

        for(j in 0..(m-1)){

            sum = sum + s[j+i]

            if(sum>d)
                break
        }

        if(sum == d){
            counter++
            sum = 0
        }

    }
    return counter

}