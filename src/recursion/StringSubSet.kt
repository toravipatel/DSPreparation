package recursion

fun main() {

    var input = "ab"
    //generateSubSet("", input)
    var nums = intArrayOf(1,2,2)



    var resultList:ArrayList<ArrayList<Int>> = generateSubSetforNumber(nums, ArrayList<Int>(), 0)
}
var resultList = ArrayList<ArrayList<Int>>()

fun generateSubSetforNumber(nums: IntArray, arrayList: ArrayList<Int>, index: Int): ArrayList<ArrayList<Int>> {
    if(index == nums.size){
        resultList.add(ArrayList<Int>(arrayList))
        return resultList
    }

    var newIndex = index+1
    while(newIndex < nums.size-1 && nums[newIndex] == nums[newIndex + 1]){
        newIndex++
    }

    generateSubSetforNumber(nums,arrayList,newIndex)
    generateSubSetforNumber(nums,ArrayList(arrayList).apply {  add(nums[index])}, newIndex)
    return resultList


}

fun generateSubSet(output:String, input:String) {
    if(input.isEmpty() || input.length == 0){
        println(output)
        return
    }

    //var outputOne = output
    //var outputTwo = output

    generateSubSet(output, input.substring(1,input.length))
    generateSubSet(output.plus(input[0]) , input.substring(1,input.length))
    return

}

