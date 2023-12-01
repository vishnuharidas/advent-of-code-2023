package day01

import util.getFileLines

fun main() {

    // Problem 1
    val result1 = getFileLines("day01/input.txt").sumOf { line ->
        line.firstOrNull { it.isDigit() }
            ?.digitToInt()
            ?.times(10)
            ?.plus(
                line.lastOrNull { it.isDigit() }
                    ?.digitToInt()
                    ?: 0
            ) ?: 0
    }

    println("Problem 1 output: $result1")

    val numbers = listOf(
        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "1", "2", "3", "4", "5", "6", "7", "8", "9"
    )

    val result2 = getFileLines("day01/input.txt").sumOf { line ->

        val first = line.findAnyOf(numbers)?.second?.anyToDigit() ?: 0
        val last = line.findLastAnyOf(numbers)?.second?.anyToDigit() ?: 0

        first * 10 + last

    }

    println("Problem 2 output: $result2")
}

private fun String.anyToDigit(): Int = listOf(
    "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
).indexOf(this) % 10