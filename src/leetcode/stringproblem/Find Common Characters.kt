package leetcode.stringproblem

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import kotlin.collections.HashMap

fun main() {
    /*var data = ArrayList<String>()

    data.add("cool")
    data.add("lock")
    data.add("cook")*/

    var data = arrayOf("bella","label","roller")


    commonChars(data).forEach {

        println(it)
    }
}

fun commonChars(A: Array<String>): List<String> {

    var dataHashMap = HashMap<Char, Int>()
    val size = A.size

    var list = ArrayList<String>()


    A[0].forEach {char->
        if (dataHashMap.containsKey(char)) {

            var currentCounter: Int? = dataHashMap.get(char)
            currentCounter?.let {

                currentCounter++
                dataHashMap.put(char, currentCounter)
            }
        } else {
            dataHashMap.put(char, 1)

        }

    }




    for (i in 1 until A.size){

        var tempHashMap = HashMap<Char, Int>()

        A[i].forEach {char->
            if (tempHashMap.containsKey(char)) {

                var currentCounter: Int? = tempHashMap.get(char)
                currentCounter?.let {

                    currentCounter++
                    tempHashMap.put(char, currentCounter)
                }
            } else {
                tempHashMap.put(char, 1)
            }
        }


        val myIterator = dataHashMap.iterator()

        while (myIterator.hasNext()){

            val item = myIterator.next()

            if(tempHashMap.containsKey(item.key)){

                val tempValue = tempHashMap.get(item.key)

                tempValue?.let { it1 -> Math.min(it1,item.value) }?.let { it2 -> dataHashMap.put(item.key, it2) }

            }
            else{
                myIterator.remove()
            }
        }


    }
    dataHashMap.forEach {

        var repeatCounter = it.value

        for (i in 0..repeatCounter-1)
            list.add(it.key.toString())


    }
    return list

}
