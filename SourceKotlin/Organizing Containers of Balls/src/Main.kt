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
 * Complete the 'organizingContainers' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts 2D_INTEGER_ARRAY container as parameter.
 */

fun organizingContainers(container: Array<Array<Int>>): String {

    val n = container.size
    val rowSums = IntArray(n) { 0 }
    val colSums = IntArray(n) { 0 }

    for (i in 0 until n) {
        for (j in 0 until n) {
            rowSums[i] += container[i][j]
            colSums[j] += container[i][j]
        }
    }
    rowSums.sort()
    colSums.sort()

    return if (rowSums.contentEquals(colSums)) "Possible" else "Impossible"

}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val n = readLine()!!.trim().toInt()

        val container = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

        for (i in 0 until n) {
            container[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        }

        val result = organizingContainers(container)

        println(result)
    }
}
