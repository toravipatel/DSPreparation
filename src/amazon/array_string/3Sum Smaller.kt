package amazon.array_string

class `3Sum Smaller` {
}
fun main() {

    threeSumSmaller(arrayOf(3,1, 0, -2).toIntArray(), target = 4)
}

fun threeSumSmaller(nums: IntArray, target: Int): Int {

    val resultList = ArrayList<List<Int>>()
    nums.sort()

    for (i in 0..nums.size-2){

        if(i ==0 || nums[i] != nums[i-1]){

            var j = i+1
            var k = nums.size - 1

            while (j < k){

                var sum = nums[i] + nums[j] + nums[k]
                if(sum < target){

                    val tripletList = ArrayList<Int>()
                    tripletList.add(nums[i])
                    tripletList.add(nums[j])
                    tripletList.add(nums[k])
                    resultList.add(tripletList)



                    while (j < k && nums[j] == nums[j+1]) j++
                    while (j < k && nums[k] == nums[k - 1]) k--

                    k--
                }
                else if(sum >= target ){
                    k--
                }
            }
        }
    }
    return resultList.size
}