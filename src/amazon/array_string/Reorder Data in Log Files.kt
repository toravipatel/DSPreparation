package amazon.array_string

import java.util.*
import kotlin.collections.ArrayList

fun main() {

}

fun reorderLogFiles(logs: Array<String>): Array<String> {

    var resultArray = ArrayList<String>()

    var logComparator = object : Comparator<String> {

        override fun compare(log1: String?, log2: String?): Int {

            var log1Split = log1?.split(" ",limit = 2)
            var log2Split = log2?.split(" ",limit = 2)

            val isDigit1 = log1Split?.get(1)?.get(0)!!.isDigit()
            val isDigit2 = log2Split?.get(1)?.get(0)!!.isDigit()

            if(!isDigit1 && !isDigit2){

                if(!log1Split.get(1).equals(log2Split.get(1)))
                    return log1Split.get(1).compareTo(log2Split.get(1))

                return log1Split.get(0).compareTo(log2Split.get(0))

            }

            return if(!isDigit1 && isDigit2){
                -1
            } else if(isDigit1 && !isDigit2)
                1
            else
                0


        }
    }


    Arrays.sort(logs,logComparator)


    return logs

}