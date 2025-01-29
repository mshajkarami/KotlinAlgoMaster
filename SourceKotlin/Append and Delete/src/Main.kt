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
 * Complete the 'appendAndDelete' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. STRING t
 *  3. INTEGER k
 */

fun appendAndDelete(s: String, t: String, k: Int): String {
    var commonLength = 0
    for (i in 0 until minOf(s.length, t.length)) {
        if (s[i] == t[i]) {
            commonLength++
        } else {
            break
        }
    }
    val sRemaining = s.length - commonLength
    val tRemaining = t.length - commonLength
    val totalOperations = sRemaining + tRemaining
    return when {

        totalOperations == k -> "Yes"


        totalOperations < k && (k - totalOperations) % 2 == 0 -> "Yes"


        k >= s.length + t.length -> "Yes"


        else -> "No"
        }

}

fun main(args: Array<String>) {
    val s = readLine()!!

    val t = readLine()!!

    val k = readLine()!!.trim().toInt()

    val result = appendAndDelete(s, t, k)

    println(result)
}
