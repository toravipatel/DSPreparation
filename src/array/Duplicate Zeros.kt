package array

fun main() {

    var myArray = IntArray(8)

    myArray[0] = 1
    myArray[1] = 0
    myArray[2] = 2
    myArray[3] = 3
    myArray[4] = 0
    myArray[5] = 4
    myArray[6] = 5
    myArray[7] = 0

    duplicateZeros(myArray)

}

fun duplicateZeros(arr: IntArray): Unit {

    var length = arr.size
    var i = 0

    while (i<length){

        if(arr[i] == 0)
        {
            for(j in length-1 downTo i+1){
                arr[j] = arr[j-1]
            }
            i = i + 2
            continue
        }

        i++
    }


}
