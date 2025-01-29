//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val firstInput = readln().trimEnd().split(" ")

    val n = firstInput[0].toIntOrNull() ?: 0
    val k = firstInput[1].toIntOrNull() ?: 0

    val secondInput = readln().trimEnd().split("")

    val rq = secondInput[0].toInt()
    val cq = secondInput[1].toInt()

    val obstacles = Array<Array<Int>>(k) { Array(2) { 0 } }

    for (i in 0 until k) {
        obstacles[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = queensAttack(n, k, rq, cq, obstacles)

    println(result)

}

fun queensAttack(n: Int, k: Int, rq: Int, cq: Int, obstacles: Array<Array<Int>>): Int {
    var up = n - rq
    var down = rq - 1
    var right = n - cq
    var left = cq - 1
    var rightUp = minOf(n - rq, n - cq)
    var rightDown = minOf(rq - 1, n - cq)
    var leftUp = minOf(n - rq, cq - 1)
    var leftDown = minOf(rq - 1, cq - 1)

    for (obstacle in obstacles) {
        val or = obstacle[0]
        val oc = obstacle[1]

        when {
            or == rq && oc > cq -> right = minOf(right, oc - cq - 1)
            or == rq && oc < cq -> left = minOf(left, cq - oc - 1)
            oc == cq && or > rq -> up = minOf(up, or - rq - 1)
            oc == cq && or < rq -> down = minOf(down, rq - or - 1)
            or > rq && oc > cq && or - rq == oc - cq -> rightUp = minOf(rightUp, or - rq - 1)
            or < rq && oc > cq && rq - or == oc - cq -> rightDown = minOf(rightDown, rq - or - 1)
            or > rq && oc < cq && or - rq == cq - oc -> leftUp = minOf(leftUp, or - rq - 1)
            or < rq && oc < cq && rq - or == cq - oc -> leftDown = minOf(leftDown, rq - or - 1)
        }
    }

    return up + down + right + left + rightUp + rightDown + leftUp + leftDown


}
