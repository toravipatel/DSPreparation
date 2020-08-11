package sorting

fun main() {

    var dataSet = intArrayOf(3,4)
    sortArrayByParityII(dataSet).forEach {
        println(it)
    }

}

fun sortArrayByParityII(A: IntArray): IntArray {

    var evenPointer = 0
    var oddPointer = 1
    var isStarPointerReadyToSwap = false
    var isEndPointerReadyToSwap = false

    while (evenPointer < A.size  && oddPointer<A.size){
        if(evenPointer%2 == 0 && A[evenPointer]%2 !=0)
            isStarPointerReadyToSwap = true
        else
            evenPointer+=2

        if(oddPointer%2 == 1 && A[oddPointer]%2 !=1)
            isEndPointerReadyToSwap = true
        else
            oddPointer+=2


        if(isStarPointerReadyToSwap && isEndPointerReadyToSwap)
        {
            var temp = A[evenPointer]
            A[evenPointer] = A[oddPointer]
            A[oddPointer] = temp


            evenPointer +=2
            oddPointer +=2

            isStarPointerReadyToSwap = false
            isEndPointerReadyToSwap  = false

        }


    }



    return A
}