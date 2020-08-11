package string

fun main() {

    var stringData = arrayOf("dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin","ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb","ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl","boygirdlggnh","xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx","nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop","hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx","juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr","lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo","oxgaskztzroxuntiwlfyufddl","tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp","qnagrpfzlyrouolqquytwnwnsqnmuzphne","eeilfdaookieawrrbvtnqfzcricvhpiv","sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz","yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue","hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv","cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo","teyygdmmyadppuopvqdodaczob","qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs","qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs")


    var chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp"

    println(countCharacters(stringData,chars))

}

fun countCharacters(words: Array<String>, chars: String): Int {

    var charMap = HashMap<Char,Int>()
    var lengthCounter = 0

    chars.forEach {

        if(charMap.containsKey(it)){

            var count: Int = charMap.get(it)!!
            charMap.put(it,++count)

        }
        else{
            charMap.put(it,1)
        }

    }

    words.forEach {

        var isCurrentWorldValid = true

        for (i in 0..it.length-1)
        {
            if(charMap.containsKey(it[i])){

                var count: Int = charMap.get(it[i])!!

               /* if(count > 1){
                    charMap.put(it[i],--count)
                }
                else{
                    charMap.remove(it[i])
                }*/
            }
            else{
                isCurrentWorldValid = false
                break
            }

        }

        if(isCurrentWorldValid)
            lengthCounter += it.length



    }



    return lengthCounter
}