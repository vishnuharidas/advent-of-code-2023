package day02

import util.getFileLines

fun main() {

    data class Game(
        val id: Int,
        val maxRed: Int,
        val maxGreen: Int,
        val maxBlue: Int
    )

    // Format:
    // Game 1: 1 red, 5 blue, 10 green; 5 green, 6 blue, 12 red; 4 red, 10 blue, 4 green
    fun String.toGame() = Game(
        id = "Game (\\d*):"
            .toRegex()
            .findAll(this)
            .map { it.groupValues[1].toInt() }
            .max(),

        maxRed = "(\\d*) red"
            .toRegex()
            .findAll(this)
            .map { it.groupValues[1].toInt() }
            .max(),

        maxGreen = "(\\d*) green"
            .toRegex()
            .findAll(this)
            .map { it.groupValues[1].toInt() }
            .max(),

        maxBlue = "(\\d*) blue"
            .toRegex()
            .findAll(this)
            .map { it.groupValues[1].toInt() }
            .max()
    )
    /*.also {
        println(this)
        println(it)
    }*/


    fun part1() {

        val maxRed = 12
        val maxGreen = 13
        val maxBlue = 14

        val sum = getFileLines("day02/input.txt")
            .map { it.toGame() }
            .filter {
                it.maxRed <= maxRed
                        && it.maxGreen <= maxGreen
                        && it.maxBlue <= maxBlue
            }
            .sumOf {
                it.id
            }

        println("Sum of possible games: $sum")

    }

    fun part2() {

        val sum = getFileLines("day02/input.txt")
            .map { it.toGame() }
            .sumOf {
                it.maxRed * it.maxGreen * it.maxBlue
            }

        println("Sum of powers: $sum")

    }

    part1()
    part2()

}