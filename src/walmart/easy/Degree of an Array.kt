package walmart.easy

fun main() {

    println(findShortestSubArray(arrayOf(1,2,2,3,1).toIntArray()))
}

fun findShortestSubArray(nums: IntArray): Int {

    val numberMap = HashMap<Int,Int>()
    nums.forEach {

        var currentFrequency = numberMap.getOrDefault(it,0)
        numberMap.put(it,currentFrequency+1)

    }

    var mostFrquentElement  = Int.MIN_VALUE
    var actualValue = Int.MIN_VALUE


    numberMap.forEach { t, u ->

        if(t > mostFrquentElement)
        {
            mostFrquentElement = t
            actualValue = u
        }

    }


    var left = 0
    var right = nums.size - 1
    var isFirstIndexFound = false
    var isLastIndexFound = false

    while (left < right && (!isFirstIndexFound && !isLastIndexFound)){

        if(!isFirstIndexFound && nums[left] == actualValue)
        {
            isFirstIndexFound = true
        }


        if(!isLastIndexFound && nums[right] == actualValue)
        {
            isLastIndexFound = true
        }

        if(!isFirstIndexFound)
            left++
        if(!isLastIndexFound)
            right--

    }


    return right - left + 1
}