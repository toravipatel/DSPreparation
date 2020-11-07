package array

import kotlin.math.max

fun minOperationsMaxProfit(customers: IntArray, boardingCost: Int, runningCost: Int): Int {

    var maxProfit = Int.MIN_VALUE
    var currentRotation = 1
    var reminderCustomer = 0
    var gondolaSize = 4
    var totalCustomerTill = 0
    var i = 0
    while (i < customers.size || reminderCustomer != 0){

        var currentPickUp = 0
        if(i < customers.size){
            currentPickUp = customers[i]
            i++
        }
        else{

        }

        if(customers[i] + reminderCustomer > 4){
            currentPickUp = 4
            reminderCustomer = customers[i] + reminderCustomer - 4
        }

        totalCustomerTill = totalCustomerTill + currentPickUp

        var currentProfit = (totalCustomerTill * boardingCost) - (currentRotation * runningCost)

        if(currentProfit < maxProfit)
            maxProfit = currentProfit


        currentRotation++

    }



    return maxProfit
}