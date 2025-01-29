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
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'squares' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER a
 *  2. INTEGER b
 */

fun squares_1(a: Int, b: Int): Int {
    var result = 0
    for (number in a .. b){
        val root = Math.sqrt(number.toDouble())
        if (root.toInt() * root.toInt() == number) {
            result++
        }
    }
    return result

}
fun isInteger(input: Any): Boolean {
    return input is Int
}
fun squares(a: Int, b: Int): Int {
    val firstSquare = ceil(sqrt(a.toDouble())).toInt()
    val lastSquare = floor(sqrt(b.toDouble())).toInt()

    return if (lastSquare >= firstSquare) lastSquare - firstSquare + 1 else 0
}
fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val a = first_multiple_input[0].toInt()

        val b = first_multiple_input[1].toInt()

        val result = squares(a, b)

        println(result)
    }
}
