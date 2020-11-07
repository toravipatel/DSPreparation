package array

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {


    var oneI = m-1
    var twoI = n-1
    var currentPointer = nums1.size-1

    while (oneI>-1 && twoI > -1){

        if(nums2[twoI] > nums1[oneI]){
            nums1[currentPointer] = nums2[twoI]
            twoI--
        }
        else
        {
            nums1[currentPointer] = nums1[oneI]
            oneI--
        }

        currentPointer--
    }

}
fun main() {

    var myArrayOne = IntArray(1)

    myArrayOne[0] = 0

    var myArrayTwo = IntArray(1)

    myArrayTwo[0] = 1



    merge(myArrayOne,0,myArrayTwo,1)

}