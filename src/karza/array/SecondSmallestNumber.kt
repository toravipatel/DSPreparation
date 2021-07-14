package karza.array

fun main() {
    val numArray = arrayOf(-4, 8, 10 , 34, 23, 0, 1)

}


fun rearrange(elements: Array<Int>): Array<Int> {
    // Write your code here

    var resultArray = IntArray(elements.size)
    var decimalBinaryMap = HashMap<Int,String>()
    elements.forEach {
        decimalBinaryMap.put(it, Integer.toBinaryString(it))
    }


    "fsnjkajs"

    return resultArray.toTypedArray()
}