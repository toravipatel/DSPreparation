package array

//https://leetcode.com/problems/find-pivot-index/

fun main() {
        var data = IntArray(6)
        data[0] = 1
        data[1] = 7
        data[2] = 3
        data[3] = 6
        data[4] = 5
        data[5] = 6

        System.out.println(pivotIndex(data))
}

fun pivotIndex(nums: IntArray): Int {

    var size = nums.size

    var leftPrefixSum = nums.clone()
    var rightPrefixSum = nums.clone()

    leftPrefixSum[0] = nums[0]
    rightPrefixSum[size - 1] = nums[size-1]

    for(i in 1..size-1){
        System.out.println("before update left array value is $" + leftPrefixSum[i])

        leftPrefixSum[i] = leftPrefixSum[i] + leftPrefixSum[i-1]

        System.out.println("after update left array value is $" + leftPrefixSum[i])

    }

    for(i in size-2 downTo 0){
        rightPrefixSum[i] = rightPrefixSum[i] + rightPrefixSum[i+1]
    }

    //compare both the array

    for(i in 0..size-1){

        System.out.println("left array value is $" + leftPrefixSum[i])
        System.out.println("right array value is $"+ rightPrefixSum[i])


        if(leftPrefixSum[i] == rightPrefixSum[i])
            return i+1
    }

    return -1

}