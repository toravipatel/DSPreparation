package contest

fun reorderSpaces(text: String): String {


    var wordsWithSpace = text.split(" ")
    var wordList = ArrayList<String>()
    var totalSpaces = 0

    var finalString = ""


    text.forEach {

        if(it == ' ')
            totalSpaces++
    }

    wordsWithSpace.forEach {

        if(it != "")
            wordList.add(it)
    }


    var equalSpace = 0
    if(wordList.size == 1 && totalSpaces == 0)
        return text
    else
        equalSpace = totalSpaces/(wordList.size-1)

    var remainingSpaces = totalSpaces

    wordList.forEachIndexed { index, s ->

        if(index != wordList.size-1)
        {
            finalString = finalString.plus(s).plus(getSpaces(equalSpace))
            remainingSpaces -= equalSpace
        }
        else
            finalString = finalString.plus(s)

    }

    finalString = finalString.trim().plus(getSpaces(remainingSpaces))

    return finalString
}

fun getSpaces(count:Int):String{

    if(count <= 0)
        return ""

    var result = ""

    for (i in 1..count)
        result = result.plus(" ")

    return  result

}

fun main() {
    println(reorderSpaces("  hello"))

}

