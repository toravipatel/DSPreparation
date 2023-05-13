package array

fun main() {

    println(removeDuplicates2(arrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3).toIntArray()))

}

fun removeDuplicates2(nums: IntArray): Int {

    if (nums.size == 1)
        return 1

    var current = 1
    var start = 0

    var currentElementCounter = 0
    if (nums[start] == nums[current]) {
        currentElementCounter++
    }

    while (current < nums.size) {

        if (nums[current] != nums[start]) {
            start++
            nums[start] = nums[current]
            currentElementCounter = 1

        } else {

            if (currentElementCounter == 2) {
                //start++
                //nums[start]  = nums[current]
            } else {
                start++
                nums[start] = nums[current]
                currentElementCounter++
            }

        }

        current++
    }

    return start + 1
}