package recursion

fun main() {

    println(reverseString("Abcd"))
}

fun reverseString(str:String):String{

    if(str.length == 1)
        return str

    return str[str.length-1].plus(reverseString(str.slice(0..str.length-2)))

}