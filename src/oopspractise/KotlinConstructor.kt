package oopspractise

fun main() {

    //var a = A()

    var person = Person("first","last")


}

class Person(val firstName: String, val lastName: String) {

    private val fullName: String = "$firstName $lastName".trim()
        .also { println("Initializing full name") }

    init {
        println("You're $fullName")
    }

    private val initials =  "${firstName.firstOrEmpty()}${lastName.firstOrEmpty()}".trim()
        .also { println("Initializing initials") }

    init {
        println("You're initials are $initials")
    }

    constructor(lastName: String): this("", lastName) {
        println("I'm secondary")
    }

    private fun String.firstOrEmpty(): Char = firstOrNull()?.toUpperCase() ?: ' '
}

class A{

    init {
        println("init block called")
    }

    constructor(){
        println("seconday construcor called")
    }

    constructor(a:Int):this(){
        println("secondary a constructor called")
    }
}

sealed class AcceptedCurrency

data class Dollar(var test:Int) : AcceptedCurrency()

class Euro : AcceptedCurrency()

class Crypto : AcceptedCurrency()