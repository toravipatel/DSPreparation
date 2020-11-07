package array



fun main() {

    var list = ArrayList<Int>()
    list.add(-1)
    //sortedSquares(list.toIntArray())
}


fun sortedSquares(A: IntArray): IntArray {

    var negativeStartPointer = 0
    var size = A.size-1


   while (A[negativeStartPointer]<0 && negativeStartPointer<size){
      negativeStartPointer++
   }

    var negativeArray = IntArray(negativeStartPointer)
    negativeStartPointer--
    var positiveArrayPointer = negativeStartPointer+1

    var i = 0
    while (negativeStartPointer > -1){

        negativeArray[i] = A[negativeStartPointer]*A[negativeStartPointer]
        negativeStartPointer--
        i++
    }

    var positiveArray = IntArray(size - positiveArrayPointer +1)
    var j = 0
    while (positiveArrayPointer <= size){

        positiveArray[j] = A[positiveArrayPointer]*A[positiveArrayPointer]
        positiveArrayPointer++
        j++
    }


    var finalArray = IntArray(size+1)
    var k = 0
    var l = 0
    var m = 0

    while (k < negativeArray.size && l < positiveArray.size){

        if(negativeArray[k] < positiveArray[l]){
            finalArray[m] = negativeArray[k]
            k++
        }
        else{
            finalArray[m] = positiveArray[l]
            l++
        }
        m++
    }

    while(k < negativeArray.size){

        finalArray[m] = negativeArray[k]
        k++
        m++

    }

    while(l < positiveArray.size){

        finalArray[m] = positiveArray[l]
        l++
        m++

    }

   return finalArray
}

/*fun sortedSquares(A: IntArray): IntArray {

    Stack<Char>()

    A.forEachIndexed { index, i ->

        A[index] = i*i

    }

    return A.sortedArray()
}
*/

//java solution Best .2 pointer approach
/*
fun sortedSquares(A: IntArray?): IntArray? {
    if (A == null) return null
    val ans = IntArray(A.size)
    var start = 0
    var end = (A.size - 1).toInt()
    var i = end // insert position.
    while (start <= end) { // <  or <=  ?   be careful about ==
        val pow1: Int = A.get(start) * A.get(start)
        val pow2: Int = A.get(end) * A.get(end)
        if (pow1 > pow2) {
            ans.get(i--) = pow1
            start++
        } else {
            ans.get(i--) = pow2
            end--
        }
    }
    return ans
}*/
