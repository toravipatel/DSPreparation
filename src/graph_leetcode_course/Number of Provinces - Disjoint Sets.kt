package graph_leetcode_course

fun main() {

    var item1 = arrayOf(1,1,0,0,0,0,0,1,0,0,0,0,0,0,0).toIntArray()
    var item2 = arrayOf(1,1,0,0,0,0,0,0,0,0,0,0,0,0,0).toIntArray()
    var item3 = arrayOf(0,0,1,0,0,0,0,0,0,0,0,0,0,0,0).toIntArray()
    var item4 = arrayOf(0,0,0,1,0,1,1,0,0,0,0,0,0,0,0).toIntArray()
    var item5 = arrayOf(0,0,0,0,1,0,0,0,0,1,1,0,0,0,0).toIntArray()
    var item6 = arrayOf(0,0,0,1,0,1,0,0,0,0,1,0,0,0,0).toIntArray()
    var item7 = arrayOf(0,0,0,1,0,0,1,0,1,0,0,0,0,1,0).toIntArray()
    var item8 = arrayOf(1,0,0,0,0,0,0,1,1,0,0,0,0,0,0).toIntArray()
    var item9 = arrayOf(0,0,0,0,0,0,1,1,1,0,0,0,0,1,0).toIntArray()
    var item10 = arrayOf(0,0,0,0,1,0,0,0,0,1,0,1,0,0,1).toIntArray()
    var item11 = arrayOf(0,0,0,0,1,1,0,0,0,0,1,1,0,0,0).toIntArray()
    var item12 = arrayOf(0,0,0,0,0,0,0,0,0,1,1,1,0,0,0).toIntArray()
    var item13 = arrayOf(0,0,0,0,0,0,0,0,0,0,0,0,1,0,0).toIntArray()
    var item14 = arrayOf(0,0,0,0,0,0,1,0,1,0,0,0,0,1,0).toIntArray()
    var item15 = arrayOf(0,0,0,0,0,0,0,0,0,1,0,0,0,0,1).toIntArray()



    var arrayData = arrayOf(item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15)
    println(findCircleNum(arrayData))

}

fun findCircleNum(isConnected: Array<IntArray>): Int {

    var uf = UF(isConnected.size)

    for (i in 0..isConnected.size-1){

        for (j in 0..isConnected.size-1){

            if(isConnected[i][j] == 1 && i!=j){
                uf.union(i,j)
            }

        }

    }

    return uf.getNumberOfProvince()

}

class UF( var size:Int){

    var numsArray = IntArray(size)
    var rankArray = IntArray(size)

    init {
        numsArray.forEachIndexed { index, i ->
            numsArray[index] = index
            rankArray[index] = 1
        }
    }

    fun find(value:Int):Int{

        if(numsArray[value] == value)
            return value

        numsArray[value] = find(numsArray[value])
        return numsArray[value]

       /*
        var valueToFind = value
        while (valueToFind != numsArray[valueToFind]){
            numsArray[valueToFind] = valueToFind
        }
        return valueToFind*/
    }

    fun union(source:Int, destination:Int){

        var sourceRoot = find(source)
        var destinationRoot = find(destination)

        var sourceRank = rankArray[sourceRoot]
        var destinationRank = rankArray[destinationRoot]

        if(sourceRoot != destinationRoot){

            if(sourceRank > destinationRank){
                numsArray[destinationRoot] = sourceRoot
            }
            else if(destinationRank > sourceRank){
                numsArray[sourceRoot] = destinationRoot
            }
            else{
                numsArray[destinationRoot] = sourceRoot
                rankArray[sourceRoot] += 1
            }
        }
    }

    fun getNumberOfProvince():Int{

        var numberSet = HashSet<Int>()

        numsArray.forEachIndexed { index, i ->


            var tempIndex = index

            while (tempIndex != numsArray[tempIndex]){
                tempIndex = numsArray[tempIndex]
            }

            numberSet.add(tempIndex)

        }



        return numberSet.size
    }

}