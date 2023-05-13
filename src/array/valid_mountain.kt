package array

//https://leetcode.com/problems/valid-mountain-array/solution/
fun main() {


}

fun validMountainArray(arr: IntArray): Boolean {

    var start = 0
    var end = arr.size - 1

    if(arr.size < 3)
        return false

    if(arr[start] >= arr[start+1])
        return false

    if(arr[end] >= arr[end-1])
        return false

    var isFirstMountainFound = false

    for (i in 0..arr.size - 2){

        if(isFirstMountainFound){

            if(arr[i+1] < arr[i])
                continue
            else
                return false

        }else{
            if(!isFirstMountainFound && arr[i+1] > arr[i])
                continue
            else
            {
                if(arr[i+1] == arr[i]){
                    return false
                }else if(arr[i+1] < arr[i]) {
                    if(!isFirstMountainFound)
                        isFirstMountainFound = true
                    else
                        return false
                }
            }
        }

    }

    return true
}