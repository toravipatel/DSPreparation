package map

fun main() {

}

fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {

    var list1Map = HashMap<String,Int>()
    var list2Map = HashMap<String,Int>()

    var minSum = Int.MAX_VALUE
    val arrayString = mutableListOf<String>()

    list1.forEachIndexed { index, s ->
        list1Map[s] = index
    }

    list2.forEachIndexed { index, s ->

        if(list1Map.containsKey(s)){
            var totalIndexSum = index+ list1Map.get(s)!!
            if(totalIndexSum<minSum){
                minSum = totalIndexSum
                arrayString.clear()
                arrayString.add(s)
            }
            else if(totalIndexSum == minSum){
                arrayString.add(s)

            }
        }
    }

    return arrayString.toTypedArray()


}