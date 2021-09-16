package graph_leetcode_course

import javax.print.attribute.standard.Destination

fun main() {

    var uf = UnionFind()
    uf.union(1, 2);
    uf.union(2, 5);
    uf.union(5, 6);
    uf.union(6, 7);
    uf.union(3, 8);
    uf.union(8, 9);

    System.out.println(uf.connected(1, 5)); // true
    System.out.println(uf.connected(5, 7)); // true
    System.out.println(uf.connected(4, 9)); // false

    // 1-2-5-6-7 3-8-9-4
    uf.union(9, 4);
    System.out.println(uf.connected(4, 9)); // true

}

class UnionFindQuickUnion{

    var numsArray = IntArray(10)

    init {

        numsArray.forEachIndexed { index, i ->
            numsArray[index] = index
        }
    }

    fun find(value:Int):Int{

        var valueToFind = value

        while(valueToFind != numsArray[valueToFind])
        {
            valueToFind = numsArray[valueToFind]
        }
        return valueToFind
    }

    fun union(source: Int, destination: Int){

        var sourceRoot = find(source)
        var destinationRoot = find(destination)

        if(sourceRoot != destinationRoot)
        {
            numsArray[destination] = sourceRoot
        }


    }

    fun connected(source:Int, destination:Int) = find(source) == find(destination)
}


