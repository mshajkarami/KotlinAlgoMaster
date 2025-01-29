import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'queensAttack' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER k
 *  3. INTEGER r_q
 *  4. INTEGER c_q
 *  5. 2D_INTEGER_ARRAY obstacles
 */

fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {

    var up = n - r_q
    var down = r_q - 1
    var left = c_q - 1
    var right = n - c_q
    var upLeft = Math.min(up, left)
    var upRight = Math.min(up, right)
    var downLeft = Math.min(down, left)
    var downRight = Math.min(down, right)
    for (obstacle in obstacles) {
        val r_o = obstacle[0]
        val c_o = obstacle[1]

        if (c_o == c_q) {
            if (r_o > r_q) up = Math.min(up, r_o - r_q - 1)
            else down = Math.min(down, r_q - r_o - 1)
        }

        if (r_o == r_q) {
            if (c_o > c_q) right = Math.min(right, c_o - c_q - 1)
            else left = Math.min(left, c_q - c_o - 1)
        }

        if (r_o - r_q == c_o - c_q) {
            if (r_o > r_q) upRight = Math.min(upRight, r_o - r_q - 1)
            else downLeft = Math.min(downLeft, r_q - r_o - 1)
        }

        if (r_o - r_q == -(c_o - c_q)) {
            if (r_o > r_q) upLeft = Math.min(upLeft, r_o - r_q - 1)
            else downRight = Math.min(downRight, r_q - r_o - 1)
        }
    }

    return up + down + left + right + upLeft + upRight + downLeft + downRight


}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val second_multiple_input = readLine()!!.trimEnd().split(" ")

    val r_q = second_multiple_input[0].toInt()

    val c_q = second_multiple_input[1].toInt()

    val obstacles = Array<Array<Int>>(k, { Array<Int>(2, { 0 }) })

    for (i in 0 until k) {
        obstacles[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = queensAttack(n, k, r_q, c_q, obstacles)

    println(result)
}
