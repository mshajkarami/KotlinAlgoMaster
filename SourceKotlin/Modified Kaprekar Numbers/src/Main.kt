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
 * Complete the 'kaprekarNumbers' function below.
 *
 * The function accepts following parameters:
 *  1. INTEGER p
 *  2. INTEGER q
 */

fun kaprekarNumbers(p: Int, q: Int) {
    val resultList = mutableListOf<Int>()

    for (number in p..q) {
        val squared = (number.toLong() * number.toLong()).toString()
        val length = squared.length
        val leftPart = if (length > 1) squared.substring(0, length - number.toString().length) else "0"
        val rightPart = squared.substring(length - number.toString().length)

        val left = if (leftPart.isNotEmpty()) leftPart.toInt() else 0
        val right = if (rightPart.isNotEmpty()) rightPart.toInt() else 0

        if (left + right == number) {
            resultList.add(number)
        }
    }

    if (resultList.isEmpty()) {
        println("INVALID RANGE")
    } else {
        println(resultList.joinToString(" "))
    }
}

fun main(args: Array<String>) {
    val p = readLine()!!.trim().toInt()

    val q = readLine()!!.trim().toInt()

    kaprekarNumbers(p, q)
}
