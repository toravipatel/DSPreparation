package walmart.easy

fun main() {

}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

    var lastPointer = nums1.size-1
    var lastDigitPointer = nums1.size - nums2.size - 1
    var secondArrayLastPointer = nums2.size - 1

    while (lastDigitPointer >= 0 && secondArrayLastPointer >=0 ){

        if(nums1[lastDigitPointer] > nums2 [secondArrayLastPointer])
        {
            nums1[lastPointer] = nums1[lastDigitPointer]
            lastDigitPointer--
        }
        else{
            nums1[lastPointer] = nums2[secondArrayLastPointer]
            secondArrayLastPointer--
        }

        lastPointer--
    }

    while (lastDigitPointer >=0){

        nums1[lastPointer] = nums1[lastDigitPointer]
        lastDigitPointer--
        lastPointer--

    }
    while (secondArrayLastPointer > 0){
        nums1[lastPointer] = nums2[secondArrayLastPointer]
        secondArrayLastPointer--
        lastPointer--
    }


}