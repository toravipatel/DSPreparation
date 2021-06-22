package amazon.array_string

//https://leetcode.com/problems/single-number/

fun main() {

}

fun singleNumber(nums: IntArray): Int {

    //using hashset approach

    /*val numberSet = HashSet<Int>()
    nums.forEach {

        if(numberSet.contains(it))
            numberSet.remove(it)
        else
            numberSet.add(it)

    }*/

    //return numberSet.firstOrNull()!!

    //using XOR approach

    var number = 0
    nums.forEach {
        number = number xor it
    }

    return number
}