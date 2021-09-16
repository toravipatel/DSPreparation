package other

import recursion.calculateCoin

fun main() {

    var initTest = InitTest(10)

}

class InitTest(var x:Int){

    init {
        println("first init block $x")
        testCompanion()
    }



    companion object{

        fun testCompanion(){
            println("test companion")
        }
    }

}