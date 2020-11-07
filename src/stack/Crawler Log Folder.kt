package stack

import java.util.*
import kotlin.collections.ArrayList

fun main() {

    var stringData = ArrayList<String>(5)

    stringData.add("d1/");
    stringData.add("d2/");
    stringData.add("../");
    stringData.add("d21/");
    stringData.add("./");


    println(minOperations(stringData.toArray() as Array<String>))

}

fun minOperations(logs: Array<String>): Int {

    var folderStack = Stack<String>()

    logs.forEach {

        if(it.contains("..")  && !folderStack.isEmpty()){
            folderStack.pop()
        }
        else if(it == "./" ){
            // do nothing
        }
        else
        {
            folderStack.push(it)
        }
    }

    return folderStack.size

}