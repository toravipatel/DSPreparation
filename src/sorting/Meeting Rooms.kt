package sorting

fun main() {

    var one = intArrayOf(7,10)
    var two = intArrayOf(2,4)

    //var final:Array<IntArray> = intArrayOf(one,two)


    //final[0] = one
    //final[1] = two

    //canAttendMeetings(final)

}

fun canAttendMeetings(intervals: Array<IntArray>): Boolean {

    intervals.sortWith( Comparator { o1, o2 ->

        o1[0] - o2[0]

    })

    intervals.forEachIndexed { i, ints ->


        if(intervals[i][1] < intervals[i+1][0])
            return false

    }


    return true

}