package array

class `3Sum` {
}

fun main() {

    var data= intArrayOf(-1, 0, 1, 2, -1, -4)
    threeSum(data).forEach {

        it.forEach {

            print(it)
        }

        println("---")

    }

}
fun threeSum(nums: IntArray): List<List<Int>> {

    var tripletLis = ArrayList<Int>()
    var finalList:ArrayList<ArrayList<Int>> = ArrayList()
    var numberSet = HashSet<Int>()

    nums.sort()
    nums.forEach {

        numberSet.add(it)
    }

    for (i in 0..nums.size-1){
        for (j in i+1..nums.size-1){
            var remainingSum = nums[i]*(-1)
            var elementToFind = 0
            if(nums[j] < 0){
                remainingSum = remainingSum-nums[j]

            }
             remainingSum = remainingSum-nums[j]

            if(numberSet.contains(elementToFind)){
                tripletLis.add(nums[i])
                tripletLis.add(nums[j])
                tripletLis.add(elementToFind)

                finalList.add(tripletLis)
            }
        }
    }


    return finalList

}
