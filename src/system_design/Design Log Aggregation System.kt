package system_design

import java.util.concurrent.ConcurrentHashMap

//https://leetcode.com/explore/learn/card/system-design/689/system-design-basics/4406
fun main() {

}

class LogAggregator(machines: Int, services: Int) {

    var machineLogMap = ConcurrentHashMap<Int,ArrayList<Int>?>()
    var serviceLogMap = ConcurrentHashMap<Int,ArrayList<Int>?>()
    var logDetailMap = ConcurrentHashMap<Int,String>()

    fun pushLog(logId: Int, machineId: Int, serviceId: Int, message: String) {

        var getCurrentLogList = machineLogMap.getOrDefault(machineId,null)
        getCurrentLogList?.let {
            it.add(logId)
            machineLogMap.put(machineId,it)
        }

        var getCurrentLogListForService = serviceLogMap.getOrDefault(serviceId,null)
        getCurrentLogListForService?.let {
            it.add(serviceId)
            serviceLogMap.put(serviceId,it)
        }

        logDetailMap.put(logId, message)

    }

    fun getLogsFromMachine(machineId: Int): List<Int> {

        var resultList = ArrayList<Int>()
        return machineLogMap.getOrDefault(machineId,resultList)!!

    }

    fun getLogsOfService(serviceId: Int): List<Int> {

        var resultList = ArrayList<Int>()
        return serviceLogMap.getOrDefault(serviceId,resultList)!!

    }

    fun search(serviceId: Int, searchString: String): List<String> {

        var resultList = getLogsOfService(serviceId)
        var searchList = ArrayList<String>()
        resultList.forEach {

            if(logDetailMap.getOrDefault(it,"").contains(searchString))
                searchList.add(logDetailMap.get(it)!!)

        }

        return searchList

    }

}
