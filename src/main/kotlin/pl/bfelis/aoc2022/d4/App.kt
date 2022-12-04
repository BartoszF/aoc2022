package pl.bfelis.aoc2022.d4

import pl.bfelis.aoc2022.getInput

fun main() {
    val input = getInput("4.txt")!!

    val lines = input.trim().split(System.lineSeparator())

    // Part 1
    val sum = lines.sumOf { handleFirstPart(it) }
    println(sum)

    // Part 2
    val secondSum = lines.sumOf { handleSecondPart(it) }
    println(secondSum)
}

fun handleFirstPart(line: String): Int {
    val (first, second) = getPair(line)

    if (first[0] >= second[0] && first[1] <= second[1]) return 1

    if (second[0] >= first[0] && second[1] <= first[1]) return 1

    return 0
}

fun handleSecondPart(line: String): Int {
    val (first, second) = getPair(line)

    if (first[0] <= second[1] && first[1] >= second[0]) return 1

    return 0
}

private fun getPair(line: String): Pair<List<Int>, List<Int>> {
    val parts = line.split(",")

    val sections = parts.flatMap { it.split("-") }.map { it.toInt() }
    val first = sections.subList(0, 2)
    val second = sections.subList(2, 4)
    return Pair(first, second)
}
