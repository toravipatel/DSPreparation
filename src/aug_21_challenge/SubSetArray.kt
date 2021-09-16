package aug_21_challenge

fun main() {

    var nums = arrayOf(1,2,3).toIntArray()
    subsets(nums).forEach {

        println(it)
    }
    subsets(nums)


    //stringSubSet("abc")

}



fun stringSubSet(data:String){

    stringSubSetUtil(data,0,"")

}


fun stringSubSetUtil(data:String,currentIndex:Int,currentSubSet:String){

    if(currentIndex == data.length)
    {
        println(currentSubSet)
        return
    }

    stringSubSetUtil(data,currentIndex+1,currentSubSet.plus(data[currentIndex]))
    stringSubSetUtil(data,currentIndex+1,currentSubSet)


}

var resultList = ArrayList<ArrayList<Int>>()

fun subsets(nums: IntArray): List<List<Int>> {

    subSetUtil(nums,currentIndex=0,currentSubset = ArrayList<Int>())
    return resultList
}

fun subSetUtil(nums: IntArray, currentIndex: Int, currentSubset: ArrayList<Int>) {

    if(currentIndex == nums.size){
        currentSubset.forEach { print(it) }
        println("------")
        return
    }

    //currentSubset.removeAt(currentIndex)
    subSetUtil(nums,currentIndex+1,currentSubset)
    currentSubset.add(nums[currentIndex])
    subSetUtil(nums,currentIndex+1,ArrayList<Int>().apply { addAll(currentSubset) })
    //currentSubset.remove(nums[currentIndex+1])


        var a = null
        a?.let{

        } ?: run {

    }

}

