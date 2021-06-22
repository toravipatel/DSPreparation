package amazon.array_string

fun main() {

    println(romanToInt("III"))
}

fun romanToInt(s: String): Int {

    var values = HashMap<String, Int>()

    values["I"] = 1;
    values["V"] = 5;
    values["X"] = 10;
    values["L"] = 50;
    values["C"] = 100;
    values["D"] = 500;
    values["M"] = 1000;
    values["IV"] = 4;
    values["IX"] = 9;
    values["XL"] = 40;
    values["XC"] = 90;
    values["CD"] = 400;
    values["CM"] = 900;


    var index = 0
    var number = 0

    while (index < s.length) {

        if(index < s.length - 1)
        {
            if (values.containsKey(s.substring(index, index + 2))) {
                number += values[s[index].toString().plus(s[index + 1].toString())]!!
                index += 2
                continue
            }
        }


        number += values.get(s[index].toString())!!
        index++

    }


    return number
}