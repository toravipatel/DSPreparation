package walmart.easy

fun main() {

}

fun climbStairs(n: Int): Int {
    if(n == 0)
        return 0


    return climbStairs(n-1) + climbStairs(n- 2)

}
