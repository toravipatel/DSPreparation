package paytm

class Solution {

    init {
        println("test")
    }

    fun eat(){
        println("eating")
    }
}

open class Component{

    open fun click(){
        println("test")
    }

}

 class Move: Component() {

     override fun click() {
         super.click()
     }

     fun work(){
         super.click()
     }

}

fun main() {
//Solution.e
}

data class Car(val brand:String, val year:Int){

    var id:Long = -1

    constructor(brand:String, year:Int, id:Long):this(brand,year){
        this.id = id
    }
}