package amazon

fun main() {

}

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var start = 0
    var end = numbers.size - 1

    var resultList = ArrayList<Int>()
    while (start < end){

        var currentTarget = numbers[start] + numbers [end]
        if(target == currentTarget)
        {
            resultList.add(start + 1)
            resultList.add(end + 1)
            break
        }
        else if(target < currentTarget){
            end--
        }
        else
            start++
    }

    return resultList.toIntArray()

}