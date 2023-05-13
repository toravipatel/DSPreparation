package photon

import java.io.IOException

data class Customer(val name:String, val number:String)

fun main() {

    var nameList = ArrayList<Customer>()
    nameList.add(Customer("Ravi","9974148884"))
    nameList.add(Customer("Patel","9974148885"))


    nameList.filter { it.name.contains("Pa") }.toList().forEach {
        println(it.name)
    }


}

open class Super{


    @Throws(IOException::class)
    public open fun show(){

    }
}

class SuperImp: Super() {


    public override fun show(){

    }


}

// Ravi Patel ABC XYZ

