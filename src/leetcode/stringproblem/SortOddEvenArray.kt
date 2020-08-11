package leetcode.stringproblem

fun main() {

    var data = ArrayList<Int>()

    data.add(8)
    data.add(5)
    data.add(2)
    data.add(3)
    data.add(7)
    data.add(90)
    data.add(3)


    sortArrayByParity(data.toIntArray()).forEach {

        println(it)
    }


    var a= -2
    var b = -2

    println(a*b)

    /*data.forEach {

        println(it)

    }
*/
}


fun sortArrayByParity(A: IntArray): IntArray {

   /* var sortedData = IntArray(A.size)

    var oddNumber = ArrayList<Int>()
    var evenNumber  = ArrayList<Int>()*/

    var i = 0
    var j = A.size-1

    while (i<j){

        var iValue= A[i] %2
        var jValue = A[j] %2

        if(iValue > jValue){

            var temp = A[i]
            A[i]= A[j]
            A[j] = temp

        }

        if(iValue == 0)
            i++
        if(jValue == 1)
            j--

    }

    return A


}

/*
fun sortArrayByParity(A: IntArray): IntArray {

    var sortedData = IntArray(A.size)

    var oddNumber = ArrayList<Int>()
    var evenNumber  = ArrayList<Int>()

    A.forEach {

        if(it % 2 == 0)
            evenNumber.add(it)
        else
            oddNumber.add(it)
    }

    evenNumber.addAll(oddNumber)

    return evenNumber.toIntArray()


}*/
