package data_structure_course


fun main() {



    var dataList = ArrayList<Int>()

    dataList.add(5)
    dataList.add(6)
    dataList.add(8)
    dataList.add(9)
    dataList.add(10)
    dataList.add(30)




    var searchElement = 7
    var lowIndex = 0
    var highIndex = dataList.size-1
    var midElement  = 0
    while(true){

        if(lowIndex>highIndex){
            println("Element not found")
            break

        }

        midElement = lowIndex + (highIndex-lowIndex)/2

        if(dataList.get(midElement) ==  searchElement){
            println("Element found")
            return
        }
        else if(dataList.get(midElement) > searchElement)
        {
            highIndex = midElement-  1
        }
        else{
            lowIndex = midElement+1
        }



    }



}