package fiserve

import java.lang.StringBuilder




class ParameterizedProducer<out T>(private val value: T) {
    fun get(): T {
        return value
    }
}

class Test< T>(private val value:T){

    fun get():T{
        return value
    }

}

fun main() {

   /* val parameterizedProducer = ParameterizedProducer("string")

    val ref: ParameterizedProducer<Any> = parameterizedProducer*/


    val data = Test(A())
    //var newObj:Test<B> = data

}


open class A{

    open fun add():Int{

        return 0
    }
}
class B: A() {

}


/*
fun main() {

    var a:A = A()



    var input1 = listOf<String>("x","y","x","y","z")
    var input2 = listOf<String>("cat","dog","cat","dog", "cat")

    println(patternCheck(input1.toList(),input2.toList()))
}*/


fun wordPattern(pattern: String, s: String): Boolean {

    var wordList = s.split(" ")

    var firstMap = HashMap<Char,String>()
    var secondMap = HashMap<String, Char>()

    pattern.forEachIndexed { index, c ->

        if(firstMap.containsKey(c)){
            if(!firstMap.get(c)!!.equals(wordList[index]) || !(secondMap.getOrDefault(wordList[index],'0') == c))
                return false
        }else{
            firstMap[c] = wordList[index]
            secondMap[wordList[index]] = c
        }
    }


    return true

}


fun patternCheck(input1:List<String>, input2:List<String>):Boolean{

    var patternMap = HashMap<String,String>()

    var i = 0
    while (i < input1.size){

        var value = patternMap.getOrDefault(input1[i],"")
        if(value.isEmpty())
            patternMap[input1[i]] = input2[i]
        else {
            if(!value.equals(input2[i]))
                return false
        }
        i++
    }


    return true
}

//x,y,x,y, x
//cat,dog,cat,dog, zaa


//x,y,x,y,z
//cat,dog,cat,dog,cat


fun getSortedFrequncy(input:String):String{

    var charMap = HashMap<Char,Int>()
    var resultString = StringBuilder()
    input.forEach {

        var currentFrequency = charMap.getOrDefault(it, 0)
        charMap[it] = ++currentFrequency

    }


    //charMap.sort


    return ""
}
/*

l 3
a 2
e 1
p 1
t 1


a 2
e 1
l 3
p 1
t 1

*/

// Ravi Patelll

// la