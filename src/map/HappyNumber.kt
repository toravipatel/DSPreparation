package map
fun isHappy(n: Int): Boolean {

    return isHappyUtility(n,HashSet<Int>())

}

fun isIsomorphic(s: String, t: String): Boolean {

    var sMap = HashMap<Char,Char>()

    for (i in s.indices){



        if(sMap.containsKey(s[i]))
        {
            if(sMap.get(s[i]) == t[i])
                continue
            else
                return false
        }
        else if(sMap.containsKey(t[i]))
        {
            if(sMap.get(t[i]) == s[i])
                continue
            else
                return false
        }
        else
        {
            sMap[s[i]] = t[i]
            sMap[t[i]] = s[i]
        }

    }
    return true
}

fun isHappyUtility(n:Int,numberSet:HashSet<Int>):Boolean{
    if(n == 1)
        return true



    var sum = 0
    var temp = n
    while(temp>0){
        var number = temp%10
        temp = temp/10
        sum = sum+(number*number)
    }

    if(numberSet.contains(sum))
        return false
    else
        numberSet.add(sum)

    return isHappyUtility(sum,numberSet)

}



fun main() {
    //println(isHappy(116))

    println(isIsomorphic("add","ecc"))
}