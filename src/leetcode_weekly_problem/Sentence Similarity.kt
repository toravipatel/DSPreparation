package leetcode_weekly_problem

//https://leetcode.com/problems/sentence-similarity/
fun main() {

 var num = ArrayList<Int>()

    num.forEachIndexed { index, i ->  }
}
var mapOne = HashMap<String,HashSet<String>>()


fun areSentencesSimilar(sentence1: Array<String>, sentence2: Array<String>, similarPairs: List<List<String>>): Boolean {

    if(sentence1.size != sentence2.size)
        return false




    similarPairs.forEach {

        if(!mapOne.containsKey(it[0])){

            var setData = mapOne.getOrDefault(it[0], HashSet<String>())
            setData.add(it[1])
            mapOne.put(it[0], setData)

        }else{

            var setData = mapOne.get(it[0])!!
            setData.add(it[1])
            mapOne.put(it[0], setData)

        }


        if(!mapOne.containsKey(it[1])){

            var setData = mapOne.getOrDefault(it[1], HashSet<String>())
            setData.add(it[0])
            mapOne.put(it[1], setData)

        }else{

            var setData = mapOne.get(it[1])!!
            setData.add(it[0])
            mapOne.put(it[1], setData)

        }

    }

    sentence1.forEachIndexed { index, s ->


        if(!s.equals(sentence2[index])){

            println("both word are not equal")

            if(!(mapOne.containsKey(s) && mapOne.get(s)!!.contains(sentence2[index])))
                return false

        }

    }

    return true
}

