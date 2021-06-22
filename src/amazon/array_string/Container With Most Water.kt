package amazon.array_string

class `Container With Most Water` {
}

fun main() {

    println(maxArea(arrayOf(1,8,6,2,5,4,8,3,7).toIntArray()))
}

fun maxArea(height: IntArray): Int {

    var maxArea = Int.MIN_VALUE

    var start = 0
    var end = height.size-1

    while (start < end){

        var area = (end - start) * Math.min(height[start], height[end])
        if(area > maxArea)
            maxArea = area

        if(height[end] > height[start])
            start++
        else
            end++
    }

    return maxArea

}