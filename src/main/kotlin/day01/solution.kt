package day01

import util.getFileLines

fun main() {

    // Problem 1
    val total = getFileLines("day01/input.txt").sumOf { line ->
        line.first { it.isDigit() }.digitToInt() * 10 + line.last { it.isDigit() }.digitToInt()
    }

    println(total)

}