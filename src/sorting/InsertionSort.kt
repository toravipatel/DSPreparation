package sorting

fun main() {

    var elementArray = intArrayOf(1,6,4,5,2,-6,0)
    insertionSort(elementArray)

    var a = "data"
    var b = "adata"

    //a.com

}

fun insertionSort(dataArray: IntArray){

    for(i in 0 until dataArray.size){

        var key = dataArray[i]
        var j = i-1

        var startElementDifference = key - dataArray[0]
        var endElementDifference = dataArray[dataArray.size-1] - key

        if(endElementDifference < startElementDifference)
        {
            while (j > -1 && dataArray[j]>key){

                dataArray[j+1] = dataArray[j]
                j--
            }

            dataArray[j+1] = key
        }
        else{
            j = 0

            while (j<i && dataArray[j]<key){

                dataArray[j+1] = dataArray[j]
                j++
            }

            dataArray[j-1] = key

        }
    }

    println("printing sorted array")

    dataArray.forEach {
        println(it)
    }



}