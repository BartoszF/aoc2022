package pl.bfelis.aoc2022.d2

import pl.bfelis.aoc2022.getInput

fun main(args: Array<String>) {
    val input = getInput("2.txt")!!

    val rounds = input.trim().split(System.lineSeparator())

    // Day 1
    val result = rounds.sumOf { handleRoundForFirstPart(it) }

    println(result)

    // Day 2
    val secondResult = rounds.sumOf { handleRoundForSecondPart(it) }

    println(secondResult)
}

fun handleRoundForFirstPart(line: String): Int {
    val players = line.split(" ").map { handleShape(it) }

    return handleScore(players[0], players[1])
}

fun handleRoundForSecondPart(line: String): Int {
    val inputs = line.split(" ")
    val shape = handleShape(inputs[0])
    val playerShape = when (inputs[1]) {
        "X" -> getLosingShape(shape)
        "Y" -> shape
        "Z" -> getWinningShape(shape)
        else -> throw Exception("Should not reach")
    }

    return handleScore(shape, playerShape)
}

fun handleScore(enemyShape: Shape, playerShape: Shape): Int {
    val score = playerShape.score

    if (enemyShape.score == playerShape.score)
        return score + 3

    if (enemyShape == Shape.ROCK) {
        return when (playerShape) {
            Shape.PAPER -> score + 6
            Shape.SCISSORS -> score
            else -> throw Exception("Nope")
        }
    }
    if (enemyShape == Shape.PAPER) {
        return when (playerShape) {
            Shape.SCISSORS -> score + 6
            Shape.ROCK -> score
            else -> throw Exception("Nope")
        }
    }
    if (enemyShape == Shape.SCISSORS) {
        return when (playerShape) {
            Shape.ROCK -> score + 6
            Shape.PAPER -> score
            else -> throw Exception("Nope")
        }
    }

    throw Exception("Should not reach!")
}

fun handleShape(letter: String): Shape = when (letter) {
    "A", "X" -> Shape.ROCK
    "B", "Y" -> Shape.PAPER
    "C", "Z" -> Shape.SCISSORS
    else -> throw Exception("Wrong shape $letter")
}

fun getWinningShape(shape: Shape): Shape = when (shape) {
    Shape.ROCK -> Shape.PAPER
    Shape.PAPER -> Shape.SCISSORS
    Shape.SCISSORS -> Shape.ROCK
}

fun getLosingShape(shape: Shape): Shape = when (shape) {
    Shape.ROCK -> Shape.SCISSORS
    Shape.PAPER -> Shape.ROCK
    Shape.SCISSORS -> Shape.PAPER
}

enum class Shape(val score: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3)
}
