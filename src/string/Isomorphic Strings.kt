package string

fun main() {

    println(isIsomorphic("paper","title"))


}

fun isIsomorphic(s: String, t: String): Boolean {

    if(s.length != t.length)
        return false

    var charMap = HashMap<Char,Char>()

    for (i in 0..s.length-1){

       if(!charMap.containsKey(s[i]) && !charMap.containsKey(t[i])){
           charMap[s[i]] = t[i]
           charMap[t[i]] = s[i]
           //return true
       }else if( !(charMap[s[i]] == t[i]  &&  charMap[s[i]] == t[i])) {
           return false
       }
    }

    return true
}