package paytm

//https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
fun main() {

    var nums = intArrayOf(4, 3, 7, 8, 6, 2, 1)
    convertArrayToZigZag(nums)
    nums.forEach { println(it) }

}

//4, 3, 7, 8, 6, 2, 1
fun convertArrayToZigZag(nums:IntArray){

    var flag = true

    for (i in 0..nums.size-2){

        if(flag){

            if(nums[i] > nums[i+1]){
                var temp = nums[i]
                nums[i] = nums[i+1]
                nums[i+1] = temp
            }

        }else{

            if(nums[i] < nums[i+1]){
                var temp = nums[i]
                nums[i] = nums[i+1]
                nums[i+1] = temp
            }

        }

        flag = !flag


    }

}