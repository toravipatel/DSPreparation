package amazon.array_string

class `3Sum Closest` {
}

fun main() {

    threeSumClosest(arrayOf(-1,0,1,2,-1,-4).toIntArray())
}

fun threeSumClosest(nums: IntArray): List<List<Int>> {

    val resultList = ArrayList<List<Int>>()
    val difference = Int.MAX_VALUE
    nums.sort()

    for (i in 0..nums.size-2){

        if(i ==0 || nums[i] != nums[i-1]){

            var j = i+1
            var k = nums.size - 1

            while (j < k){

                var sum = nums[i] + nums[j] + nums[k]
                /*if(sum == 0){
                    val tripletList = ArrayList<Int>()
                    tripletList.add(nums[i])
                    tripletList.add(nums[j])
                    tripletList.add(nums[k])
                    resultList.add(tripletList)

                    j++
                    k--

                    while (j < k && nums[j] == nums[j+1]) j++
                    while (j < k && nums[k] == nums[k - 1]) k--

                }
                else */
                if(sum < 0){
                    j++
                }
                else{
                    k--
                }
            }
        }
    }
    return resultList
}