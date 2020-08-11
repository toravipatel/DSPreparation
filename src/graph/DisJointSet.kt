package graph


data class DSNode(val  data:Long, var rank:Int = 0, var  parent:DSNode?=null)

class DSUtil{

    val dsMap = HashMap<Long,DSNode>()

    fun makeSet(data:Long){

        val dsNode = DSNode(data,0)
        dsNode.parent = dsNode
        dsMap.put(data,dsNode)

    }

    fun union(data1:Long,data2:Long):Boolean{

        val node1 = dsMap.get(data1)
        val node2 = dsMap.get(data2)

        val parent1 = findSet(node1!!)
        val parent2 = findSet(node2!!)

        if(parent1.data == parent2.data)
            return false
        else{
            if(parent1.rank >= parent2.rank){

                parent1.rank = parent1.rank++
                parent2.parent = parent1

            }
            else{

                parent1.parent = parent2

            }
        }


        return true
    }

    fun findSet(data: Long): Long {
        return findSet(dsMap.get(data)!!).data
    }

    fun findSet(node:DSNode):DSNode{

        var tempNode = node.parent

        if(tempNode == node)
            return tempNode


        tempNode = tempNode?.let { findSet(it) }
        return tempNode!!


    }



}

fun main() {

    val dsUtil = DSUtil()
    dsUtil.makeSet(1)
    dsUtil.makeSet(2)
    dsUtil.makeSet(3)
    dsUtil.makeSet(4)
    dsUtil.makeSet(5)
    dsUtil.makeSet(6)
    dsUtil.makeSet(7)

    dsUtil.union(1,2)
    dsUtil.union(2,3)
    dsUtil.union(4,5)
    dsUtil.union(6,7)
    dsUtil.union(5,6)
    //dsUtil.union(3,7)

    System.out.println(dsUtil.findSet(1));
    System.out.println(dsUtil.findSet(2));
    System.out.println(dsUtil.findSet(3));
    System.out.println(dsUtil.findSet(4));
    System.out.println(dsUtil.findSet(5));
    System.out.println(dsUtil.findSet(6));
    System.out.println(dsUtil.findSet(7));




}