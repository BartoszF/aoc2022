package pl.bfelis.aoc2022.d1

import pl.bfelis.aoc2022.getInput

fun main(args: Array<String>) {
    val input = getInput("1.txt")!!
    val sets = input.split("\n\n")
    val elfs = sets.map { Elf(it.split("\n").filter { n -> n.isNotBlank() }.map { num -> num.trim().toInt() }) }

    val sums = elfs.map { it.sum() }
    // PART 1
    val maxFood = sums.maxOrNull()
    println(maxFood)

    // PART 2
    val maxThree = sums.sortedDescending().take(3).sum()
    println(maxThree)
}

data class Elf(val food: List<Int>) {
    fun sum() = food.sum()
}
