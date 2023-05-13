package dp


//https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
fun main() {

    var tasks = Array(3, {IntArray(3)})
    var first = intArrayOf(18,11,29)
    var second = intArrayOf(4 ,13, 7)
    var third = intArrayOf(1, 8, 13)

    tasks[0] = first
    tasks[1] = second
    tasks[2] = third

    println(ninjaTraining(tasks))

}

fun ninjaTraining(tasks:Array<IntArray>):Int{

    return  ninjaTrainingUtil(tasks.size - 1, 3, tasks)

}

fun ninjaTrainingUtil(currentDay:Int, lastTask:Int, tasks:Array<IntArray>):Int{
    if(currentDay == 0){

        var max = Int.MIN_VALUE

        for(i in 0..2){
            if(i == lastTask)
                continue

            max = Math.max(max, tasks[0][i])
        }
        return max
    }

    var levelMax = Int.MIN_VALUE
    for(i in 0..2){

        if(i == lastTask)
            continue
        var result = tasks[currentDay][i] + ninjaTrainingUtil(currentDay-1, i,tasks)

        levelMax = Math.max(levelMax,result)

    }

    return  levelMax

}