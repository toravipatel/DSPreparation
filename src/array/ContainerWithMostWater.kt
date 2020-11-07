package array



fun main() {

    println("test")
    var data= intArrayOf(1,8,6,2,5,4,8,3,7)
    println(maxArea(data))
}

fun maxArea(height: IntArray): Int {

    var startPoineter = 0
    var endPointer = height.size-1
    var maxProfit = Int.MIN_VALUE


    while (startPoineter<=endPointer){

        var area = Math.min(height[startPoineter],height[endPointer]) * (endPointer-startPoineter)
        if(area > maxProfit)
            maxProfit = area

        if(height[startPoineter]>height[endPointer])
            endPointer--
        else
            startPoineter++

    }

    return maxProfit

}

fun calculaeArea(){

}