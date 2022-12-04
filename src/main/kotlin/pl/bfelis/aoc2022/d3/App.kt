package pl.bfelis.aoc2022.d3

import pl.bfelis.aoc2022.getInput

fun main() {
    val input = getInput("3.txt")!!

    val lines = input.trim().split(System.lineSeparator())

    // Part 1
    val sum = lines.sumOf { handleFirstPartLine(it) }
    println(sum)

    // Part 2
    val secondSum = lines.chunked(3).sumOf { handleSecondPart(it[0], it[1], it[2]) }
    println(secondSum)
}

fun handleSecondPart(first: String, second: String, third: String): Int {
    val firstChars = first.toSet()
    val secondChars = second.toSet()
    val thirdChars = third.toSet()

    val intersect = firstChars.intersect(secondChars).intersect(thirdChars)

    return getCharValue(intersect.first())
}

fun handleFirstPartLine(line: String): Int {
    val firstHalf = line.substring(0, line.length / 2)
    val secondHandle = line.substring(line.length / 2)

    var occurs: Char? = null

    for (i in firstHalf.indices) {
        val c = firstHalf[i]
        if (secondHandle.contains(c, false)) {
            occurs = c
            break
        }
    }

    return getCharValue(occurs!!)
}

fun getCharValue(c: Char): Int {
    return if (c.isLowerCase()) {
        c.code - 96
    } else {
        c.code - 64 + 26
    }
}
