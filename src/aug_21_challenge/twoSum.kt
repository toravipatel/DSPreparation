package aug_21_challenge

fun main() {

}

fun twoSum(nums: IntArray, target: Int): IntArray {

    var numMap = HashMap<Int,Int>()
    nums.forEachIndexed { index, i ->

        var valueToFind = target - i

        if(numMap.containsKey(valueToFind))
            return arrayOf(index,numMap.get(valueToFind)!!).toIntArray()
        else
            numMap[i] = index
    }

    return arrayOf(0,1).toIntArray()
}