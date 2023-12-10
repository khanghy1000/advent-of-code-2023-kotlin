package day01

import readInput

fun String.getFirstDigit(): Char? {
    for (ch in this) {
        if (ch.isDigit()) return ch
    }
    return null
}

fun String.getLastDigit(): Char? {
    for (ch in this.reversed()) {
        if (ch.isDigit()) return ch
    }
    return null
}

fun String.getCalibrationValue():Int {
    return "${this.getFirstDigit() ?: '0'}${this.getLastDigit() ?: '0'}".toInt()
}

fun main() {
    val input = readInput("day01/Day01")
    val sum = input.sumOf { it.getCalibrationValue() }

    print(sum)
}
