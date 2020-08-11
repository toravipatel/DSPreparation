import java.util.*
import java.util.Collections.swap
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.cos



class MyClass {
}



fun main() {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val money = scan.nextLine().trim().toInt()

        val n = scan.nextLine().trim().toInt()

        val cost = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        whatFlavors(cost, money)


    }
}

// Complete the whatFlavors function below.
fun whatFlavors(cost: Array<Int>, money: Int): Unit {





    var iceCreamHashList  = HashMap<Int,Int>()


    cost.forEachIndexed { index, i ->

        var differenceMoney = money - cost[index]

        if(iceCreamHashList.containsKey(differenceMoney)){

            val output = (iceCreamHashList.get(differenceMoney)!! + 1).toString().plus(" ".plus (index+1))
            println(output)
            return

        }
        else{
            iceCreamHashList.put(cost[index],index)
        }


    }




}

// Complete the maximumToys function below.
fun maximumToys(prices: Array<Int>, k: Int): Int {

    var toysCounter = 0

    prices.sort()

    var totalPrice= 0

   for(i in 0..(prices.size-1)){
       if(i == 0 && prices[i] > k)
       {
           break
       }
       else{
           totalPrice  += prices[i]
           toysCounter++
           if(totalPrice>k)
           {
               toysCounter--
               break
           }
       }
   }


    return toysCounter


}

// Complete the countSwaps function below.
fun countSwaps(a: Array<Int>): Unit {
    var  swapCounter:Int=  0

   for(i in 0 until a.size-1){

       for( j in 0..(a.size-2) ){
           if(a[j]>a[j+1])
           {
               var temp = 0

               temp  = a[j]
               a[j]  = a[j+1]
               a[j+1] = temp
               swapCounter++
           }
       }
   }

    println("Array is sorted in $swapCounter swaps.")
    println("First Element: ${a[0]}")
    println("Last Element: ${a[a.size-1]}")

}

fun swap(firstElement:Int,secondElement:Int){

  /*  var temp = 0

    temp  = firstElement
    firstElement  = secondElement
    secondElement = temp*/

}

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {


    //ar.sort()

    val clothSet = HashSet<Int>()


    var clothingPairCounter=0

    ar.forEachIndexed { index, i ->

        if(index== 0)
        {
            clothSet.add(i)
        }
        else
        {
            if(clothSet.contains(i))
            {
                clothSet.remove(i)
                clothingPairCounter++
            }
            else
            {
                clothSet.add(i)
            }
        }

    }

    return clothingPairCounter

}

fun diagonalDifference(arr: Array<Array<Int>>): Int {



    for( i  in  arr){

        for( j in arr){



        }

    }

    return 0

}





// Complete the aVeryBigSum function below.
fun aVeryBigSum(ar: Array<Long>): Long {

    var sum:Long  = 0


    ar.forEach {

        sum += it
    }

    return sum

}

// Complete the alternatingCharacters function below.
fun alternatingCharacters(s: String): Int {

    var counter = 0

    s.forEachIndexed { index, c ->

        if(index < s.length-1)
        {
            if(c == s[index+1])
                counter++
        }

    }

    return counter


}

// Complete the makeAnagram function below.
fun makeAnagram(a: String, b: String): Int {

    val map1 = HashMap<Char,Int>()

    for (i in 0 until a.length){

        if(map1.containsKey(a[i]))
            map1.put(a[i],map1.getValue(a[i])+ 1)
        else
            map1.put(a[i],1)
    }

    for (i in 0 until b.length){

        if(map1.containsKey(b[i])){
            map1.put(b[i],map1.getValue(b[i]) - 1)
        }
        else
            map1.put(b[i],-1)
    }

    var differenceCount = 0

    map1.forEach { t, u ->

        if(map1.get(t)!! !=  0){
            differenceCount = differenceCount + Math.abs(map1.get(t)!!)
        }
    }





    return differenceCount


}
// Complete the sherlockAndAnagrams function below.
fun sherlockAndAnagrams(s: String): Int {




    var anagramCounter = 0

    val stringSet = HashSet<String>()

    for(i in 1 until  s.length +1){

        for(j in 0 until(s.length - i +1) ){



            val subString = String(s.substring(0,j+1).plus(s.substring(j+1,j+i)).toCharArray().sortedArray())
            println("sub string is $subString")

            if(!stringSet.add(subString))
                anagramCounter++


        }
    }

    return anagramCounter

}
