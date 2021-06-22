package contest

fun main() {

    println(paymentPairs(arrayOf(40,60,80)))
}

fun paymentPairs(payments: Array<Int>): Long {
    // Write your code here

    var paymentsMap = HashMap<Int,Int>()
    var totalPair = 0L

    payments.forEach {
        if(paymentsMap.contains(it))
        {
            paymentsMap[it] = paymentsMap.getOrDefault(it,1) + 1
        }
        else
            paymentsMap[it] = 1
    }

    paymentsMap.forEach { t, u ->

        if(t%100 != 0){

            var itemToSearch = Math.abs(100 - t)

            if (itemToSearch != t)
            {
                var frequency = paymentsMap.getOrDefault(itemToSearch, 0)
                totalPair = totalPair + frequency
            }
            else
            {
                var frequency = paymentsMap.getOrDefault(itemToSearch, 0)
                totalPair = totalPair + frequency - 1
            }
        }
        else if(t%100 == 0){



            if (paymentsMap.getOrDefault(t,1) > 1)
            {
                totalPair = totalPair + paymentsMap.getOrDefault(t,1) - 1
            }
            else
            {
                var nextItemToSearch  = 1000 - t
                if(paymentsMap.containsKey(nextItemToSearch))
                {
                    var frequency = paymentsMap.getOrDefault(nextItemToSearch, 1)
                    if(frequency > 1)
                        totalPair = totalPair + frequency - 1
                    else
                        totalPair = totalPair + frequency
                }

            }

        }



    }

    return totalPair




}