package recursion

fun main() {


    println(palidromString("aaaaaa",0,5))
}

fun palidromString(str: String,leftPointer:Int,rightPointer:Int):Boolean{

    if(leftPointer >= rightPointer)
        return true

    if(str[leftPointer] != str[rightPointer])
        return false


    return palidromString(str,leftPointer+1,rightPointer-1)
}