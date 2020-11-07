package leet_code_contest

class ParkingSystem(big: Int, medium: Int, small: Int) {

    var parkingMap = HashMap<Int,Int>()

    init {

        parkingMap.put(CAR_TYPE_BIG,big)
        parkingMap.put(CAR_TYPE_MEDIUM,medium)
        parkingMap.put(CAR_TYPE_SMALL,small)

    }
    companion object{

        var CAR_TYPE_BIG = 1
        var CAR_TYPE_MEDIUM = 2
        var CAR_TYPE_SMALL = 3

    }


    fun addCar(carType: Int): Boolean {

        if(parkingMap.containsKey(carType) && parkingMap.get(carType)!! > 0){
            parkingMap.put(carType,parkingMap.get(carType)!! - 1)
            return true
        }

        return false
    }

}
