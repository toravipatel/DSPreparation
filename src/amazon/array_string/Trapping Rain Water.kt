package amazon.array_string

fun main() {

    println(trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
}

fun trap(height: IntArray): Int {

    var leftMax = IntArray(height.size)
    var rightMax = IntArray(height.size)


    leftMax[0] = height[0]
    var leftMaxValue = height[0]
    for (i in 1..height.size-1)
    {
        leftMax[i] = Math.max(height[i],leftMax[i-1])

    }


    rightMax[height.size-1] = height[height.size-1]
    var rightMaxValue = Int.MIN_VALUE
    for (i in height.size-2 downTo 0)
    {
        rightMax[i] = Math.max(height[i],rightMax[i+1])
    }


    var totalWaterStorage = 0

    for (i in 0..height.size-1){
        totalWaterStorage += (Math.min(leftMax[i],rightMax[i]) - height[i])
    }

    return totalWaterStorage
}