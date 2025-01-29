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
import kotlin.math.sqrt
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'encryption' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun encryption(s: String): String {

    val cleaned = s.replace(" ", "")


    val columns = kotlin.math.ceil(sqrt(cleaned.length.toDouble())).toInt()
    val rows = if (columns * (columns - 1) >= cleaned.length) columns - 1 else columns


    val encryptedList = mutableListOf<String>()

    for (col in 0 until columns) {
        val sb = StringBuilder()
        for (row in 0 until rows) {
            val index = row * columns + col
            if (index < cleaned.length) {
                sb.append(cleaned[index])
            }
        }
        encryptedList.add(sb.toString())
    }


    return encryptedList.joinToString(" ")
}

fun main(args: Array<String>) {

    val s = readLine()!!


    val result = encryption(s)

    println(result)
}
