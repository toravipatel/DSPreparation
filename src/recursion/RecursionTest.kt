package recursion

fun printData(counter:Int){
    println(counter)

    if(counter < 0)
        return
    else{

        printData(counter-2)
        printData(counter+1)

    }
}

fun main() {
    printData(10)
}

