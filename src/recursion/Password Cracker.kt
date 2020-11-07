package recursion

class `Password Cracker` {
}

fun main() {

    val passwordArray = arrayOf("we","can")
    println(passwordCracker(passwordArray,"wecan"))



}

fun passwordCracker(passwords: Array<String>, loginAttempt: String): String {



    return getPassword(passwords,loginAttempt,"")

}

fun getPassword(passwords: Array<String>, remainingPassword:String, loginAttempt: String):String{

    if(remainingPassword.isEmpty())
        return ""


    var mRemainingPassword = remainingPassword
    var mLoginAttempt = loginAttempt

    passwords.forEachIndexed { index, s ->

        if(mRemainingPassword.startsWith(s)){
            mRemainingPassword = mRemainingPassword.substring(s.length,remainingPassword.length)
            mLoginAttempt = mLoginAttempt.plus(s).plus(" ")

            if(mRemainingPassword.isEmpty())
                return ""

        }


    }

    return getPassword(passwords,mRemainingPassword,mLoginAttempt)



}