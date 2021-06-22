package amazon.array_string

class `Two Sum  Solution` {
}

fun main() {

    val numArray = arrayOf(2,7,11,15)
    println(twoSum(numArray.toIntArray(),9))

}

fun twoSum(nums: IntArray, target: Int): IntArray {

    var numberMap = HashMap<Int,Int>()
    val outPut = IntArray(2)
    nums.forEachIndexed { index, i ->

        val otherNumber = Math.abs(target - i)

        if(numberMap.containsKey(otherNumber)){

            var otherNumberIndex = numberMap.get(otherNumber)
            outPut[0] = index
            outPut[1] = otherNumberIndex!!
            return outPut
        }
        else
            numberMap[i] = index
    }

    return outPut
}

