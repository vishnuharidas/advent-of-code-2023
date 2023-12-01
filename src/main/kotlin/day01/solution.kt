package day01

import util.getFileLines

fun main() {

    // Problem 1
    val total = getFileLines("day01/input.txt").sumOf { line ->
        line.firstOrNull { it.isDigit() }
            ?.digitToInt()
            ?.times(10)
            ?.plus(
                line.lastOrNull { it.isDigit() }
                    ?.digitToInt()
                    ?: 0
            ) ?: 0
    }

    println("Problem 1 output: $total")

}