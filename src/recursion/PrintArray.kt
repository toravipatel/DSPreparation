package recursion

fun main() {

    printArray(intArrayOf(10,20,30,40))

}

fun printArray(dataArray: IntArray){

    if(dataArray.size == 1)
    {
        println(dataArray[0])
        return
    }

    println(dataArray[0])

    return printArray(dataArray.sliceArray(1 until dataArray.size))

}