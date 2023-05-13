package clover



//x,y,x,y, z
//cat,dog,cat,dog, cat

// x, y, x,

fun main() {

    var listOne = ArrayList<String>()
    listOne.add("x")
    listOne.add("y")
    listOne.add("x")
    listOne.add("y")
    //listOne.add("z")

    var listTwo = ArrayList<String>()
    listTwo.add("cat")
    listTwo.add("dog")
    listTwo.add("cat")
    listTwo.add("dog")
    //listTwo.add("cat")

    println(matchPattern(listOne,listTwo))
}

fun matchPattern(listOne:ArrayList<String>,listTwo:ArrayList<String>):Boolean{

    if(listOne.size != listTwo.size)
        return false


    var mapOne = HashMap<String,String>()
    var mapTwo = HashMap<String,String>()


    for (i in 0..listOne.size-1){

        if(mapOne.contains(listOne[i])){

            var existingValue = mapOne[listOne[i]]
            if(!existingValue.equals(listTwo[i]))
                return false
        }
        else if(mapTwo.containsKey(listTwo[i])){

            var existingValue = mapTwo[listTwo[i]]
            if(!existingValue.equals(listOne[i]))
                return false
        }
        else{
            mapOne[listOne[i]] = listTwo[i]
            mapTwo[listTwo[i]] = listOne[i]
        }
    }

    return true
}

