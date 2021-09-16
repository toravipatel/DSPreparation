package string

fun main() {

    var data = ArrayList<String>()
    data.add("flowers")
    data.add("flops")
    data.add("floats")
    longestCommonPrefix(data)

}

fun longestCommonPrefix(array:ArrayList<String>){

    var start = 0
    var minLength = Int.MAX_VALUE

    array.forEach {
        minLength = Math.min(minLength, it.length)
    }

    for (i in 0..minLength){

        var firstChar =

        array.forEach {
            //currentLevelResult = currentLevelResult xor it[0].toInt()


        }

        /*if(currentLevelResult == 0)
            continue
        else
        {
            System.out.println("common prefix is ${ array[i].substring(0,i) }")
            break
        }*/

    }
}