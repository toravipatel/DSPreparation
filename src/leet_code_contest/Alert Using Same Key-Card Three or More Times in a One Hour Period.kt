package leet_code_contest

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


fun main() {

    var nameArray = listOf("a","a","a","a","a","a","b","b","b","b","b")
    var timeArray = listOf("23:27","03:14","12:57","13:35","13:18","21:58","22:39","10:49","19:37","14:14","10:41")

    println(alertNames(nameArray.toTypedArray(),timeArray.toTypedArray()))

}

fun isTimeDiffernceMoreThanOneHour(startTime:String,endTime:String):Boolean{

    var startSplit = startTime.split(":")
    var endSplit = endTime.split(":")

    if(startSplit[0].toInt()< 24 && endSplit[0].toInt() > 0){
        return true
    }

    var format = SimpleDateFormat("HH:MM")
    var time1 = format.parse(startTime)
    var time2 = format.parse(endTime)

    var milli = time2.time - time1.time
    //var minutes = (milli/1000 * 60)

    val hours = milli / (1000 * 60 * 60)
    val mins = milli / (1000 * 60) % 60

    println("total minutes are $mins")
    return (hours*60 + mins)  > 60
}

fun alertNames(keyName: Array<String>, keyTime: Array<String>): List<String> {

    var resultList = ArrayList<String>()
    var nameTimeMap = HashMap<String,List<String>>()

    keyName.forEachIndexed { index, s ->

        if(nameTimeMap.containsKey(s)){
            var list = nameTimeMap[s]
            (list as ArrayList).add(keyTime[index])
            nameTimeMap[s] = list
        }
        else{
            var timeList = ArrayList<String>()
            timeList.add(keyTime[index])
            nameTimeMap.put(s,timeList)
        }
    }


    nameTimeMap.forEach { s, list ->


        val timeQueue:Queue<String>  = LinkedList<String>()
        //timeQueue.add(list[0])

        for (i in 0..list.size-1)
        {
            timeQueue.add(list[i])
            if(timeQueue.size == 3){

                if(isTimeDiffernceMoreThanOneHour(timeQueue.first(),timeQueue.last())){
                    timeQueue.poll()
                }else{
                    resultList.add(s)
                    break
                }
            }
        }

    }


    resultList.sort()
    return resultList

}