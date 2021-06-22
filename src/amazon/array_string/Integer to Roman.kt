package amazon.array_string

class `Integer to Roman` {
}


fun main() {

    println(intToRoman(100))
}

fun intToRoman(num: Int): String {
    var values = LinkedHashMap<Int, String>()

    values[1000] = "M";
    values[900] = "CM";
    values[500] = "D";
    values[400] = "CD";
    values[100] = "C";
    values[90] = "XC";
    values[50] = "L";
    values[40] = "XL";
    values[10] = "X";
    values[9] = "IX";
    values[5] = "V";
    values[4] = "IV";
    values[1] = "I";



    var index = 0
    var romanNumber = ""
    var reminder = 0
    var number = num

    while (number > 1){

        for (value in values) {

            reminder = num - value.key
            if(reminder > 0)
            {
                romanNumber = romanNumber.plus(values[value.key]).toString()
                //number = number - values.get(value.key)
                continue
            }
        }
        if(reminder == 0)
            break
    }

   return romanNumber




    return romanNumber.toString()
}