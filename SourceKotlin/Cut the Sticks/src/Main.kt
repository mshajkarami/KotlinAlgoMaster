import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

/*
 * Complete the 'cutTheSticks' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun cutTheSticks(arr: Array<Int>): Array<Int> {
    var localArr = arr.toList()
    val result = mutableListOf<Int>()
    var index = 0
    while (localArr.isNotEmpty()) {
        result.add(localArr.size)
        val min = localArr.minOrNull() ?: break
        localArr = localArr.map { it - min!! }.filter { it > 0 }
    }
    return result.toTypedArray()
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = cutTheSticks(arr)

    println(result.joinToString("\n"))
}
