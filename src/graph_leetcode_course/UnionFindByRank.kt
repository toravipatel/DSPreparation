package graph_leetcode_course

fun main() {

    val uf = UnionByRank()
    // 1-2-5-6-7 3-8-9 4
    // 1-2-5-6-7 3-8-9 4
    uf.union(1, 2)
    uf.union(2, 5)
    uf.union(5, 6)
    uf.union(6, 7)
    uf.union(3, 8)
    uf.union(8, 9)
    println(uf.connected(1, 5)) // true
    println(uf.connected(5, 7)) // true
    println(uf.connected(4, 9)) // false
    // 1-2-5-6-7 3-8-9-4
    // 1-2-5-6-7 3-8-9-4
    uf.union(9, 4)
    println(uf.connected(4, 9)) // true

}

class UnionByRank{
    var numsArray = IntArray(10)
    var rankArray = IntArray(10)

    init {
        numsArray.forEachIndexed { index, value ->

            numsArray[index] = index
            rankArray[index]  = 1
        }
    }

    fun find(x:Int):Int{

        var temp = x

        if(temp == numsArray[temp])
            return temp

        temp = numsArray[temp]
        return temp


    }

    fun union(x:Int, y:Int){
        var rootX = find(x)
        var rootY = find(y)

        println("root for $x is $rootX")
        println("root for $y is $rootY")


        if(rootX != rootY){
            if(rankArray[x] > rankArray[y])
            {
                numsArray[x] = rootY
            }else if(rankArray[x] < rankArray[y]){
                numsArray[y] = rootX
            }else{
                numsArray[y] = rootX
                rankArray[x] =+ 1
            }
        }
    }

    fun connected(x:Int, y:Int):Boolean{
        return find(x) == find(y)
    }

}

class UnionFindByRank{

    var numsArray = IntArray(10)
    var rankArray = IntArray(10)

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
    }

    fun union(source:Int, destination:Int){

        var sourceRoot = find(source)
        var destinationRoot = find(destination)

        var sourceRank = rankArray[source]
        var destinationRank = rankArray[destination]

        if(sourceRoot != destinationRoot){

            if(sourceRank > destinationRank){
                numsArray[destination] = source
            }
            else if(destinationRank > sourceRank){
                numsArray[source] = destination
            }
            else{
                numsArray[destination] = source
                rankArray[source] += 1
            }
        }
    }

    fun connected(source:Int, destination:Int) = find(source) == find(destination)

}