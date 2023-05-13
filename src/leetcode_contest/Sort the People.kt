package leetcode_contest

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

//https://leetcode.com/problems/sort-the-people/description/
fun main() {

}

fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {

    var dataMap = HashMap<Int, String>()

    names.forEachIndexed { index, s ->
            dataMap.put(heights[index], s)
    }

    heights.sortDescending()

    var resultArray = ArrayList<String>()

    heights.forEachIndexed { index, i ->

        resultArray.add(dataMap.get(i)!!)

    }
    return resultArray.toTypedArray()

}