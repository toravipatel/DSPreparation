package interview

fun main() {

    val numArray = arrayOf(4,3,2,7,8,2,3,1)

    //for empty array
    //val numArray = IntArray(0)

    findDuplicate(numArray.toIntArray())

}

fun findDuplicate(nums: IntArray){

    var numberMap = HashMap<Int,Int>()

    nums.forEach {
        var currentFrequency = numberMap.getOrDefault(it,0)
        numberMap.put(it,currentFrequency+1)
    }

    numberMap.forEach { t, u ->
        if(u > 1)
            println("$t is more than once in array")
    }
}