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
 * Complete the 'acmTeam' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts STRING_ARRAY topic as parameter.
 */

fun acmTeam(topic: Array<String>): Array<Int> {

    var maxTopics = 0
    var teamCount = 0

    for (i in 0 until topic.size ) {
        for (j in i + 1 until topic.size ) {
            val combinedTopics = topic[i].zip(topic[j]) { a, b -> if (a == '1' || b == '1') '1' else '0' }
            val coveredTopics = combinedTopics.count() { it == '1' }
            if (coveredTopics > maxTopics) {
                maxTopics = coveredTopics
                teamCount = 1
            } else if (coveredTopics == maxTopics) teamCount++
        }
    }

    return arrayOf(maxTopics, teamCount)


}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val topic = Array<String>(n, { "" })
    for (i in 0 until n) {
        val topicItem = readLine()!!
        topic[i] = topicItem
    }

    val result = acmTeam(topic)

    println(result.joinToString("\n"))
}
