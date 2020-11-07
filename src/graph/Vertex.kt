package graph

import java.util.*
import kotlin.collections.HashMap

class Vertex(var value:Int){

     var adjecentList = LinkedList<Vertex>()


    override fun equals(other: Any?): Boolean {
        return this.value == (other as Vertex).value
    }

    override fun hashCode(): Int {
        return this.value
    }

    /*override fun toString(): String {
        return "-"+value
    }*/
 }

class GraphManager{

    lateinit var graphList:LinkedList<Vertex>

    init {
        graphList = LinkedList()
    }


    fun addVertex(value: Int){

        val newVertex = Vertex(value)
        graphList.add(newVertex)

    }

    fun readGraphData(value: Int){

        var startVertex = Vertex(value)

        println("------------------")

        if(graphList.contains(startVertex))
        {


            graphList.forEach {it->

                if(it.value  == value){
                    it.adjecentList.forEach {it1->

                        println("${startVertex.value} -> ${it1.value}")

                    }
                }

            }



        }

    }


    fun addVertexConnection(valueOne:Int,valueTwo:Int)
    {

        val vertexOne = Vertex(valueOne)
        val vertexTwo = Vertex(valueTwo)


        graphList.forEach {

            if(it.value == valueOne){

                it.adjecentList.add(vertexTwo)

            }

            if(it.value == valueTwo){
                it.adjecentList.add(vertexOne)

            }

        }

    }



}

fun main() {

    var graphManager = GraphManager()
    for(i in 1..10){
        graphManager.addVertex(i)
    }


    graphManager.addVertexConnection(1,5)
    graphManager.addVertexConnection(1,8)
    graphManager.addVertexConnection(5,6)
    graphManager.addVertexConnection(3,9)
    graphManager.readGraphData(1)
    graphManager.readGraphData(3)
    graphManager.readGraphData(9)
    graphManager.readGraphData(8)

}