package day01

import readInput

val SPELLED_OUT_NUMBERS = mapOf(
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9
)

fun String.getCalibrationValueWithSpelledOutNum(): Int {
    val spelledOutNums = SPELLED_OUT_NUMBERS.map {
        mapOf(
            "num" to it.value,
            "index" to this.indexOf(it.key)
        )
    } + SPELLED_OUT_NUMBERS.map {
        mapOf(
            "num" to it.value,
            "index" to this.lastIndexOf(it.key)
        )
    }

    val firstDigit =
        mapOf(
            "num" to (this.getFirstDigit()?.digitToInt() ?: 0),
            "index" to this.indexOf(this.getFirstDigit().toString())
        )
    val lastDigit =
        mapOf(
            "num" to (this.getLastDigit()?.digitToInt() ?: 0),
            "index" to this.lastIndexOf(this.getLastDigit().toString())
        )

    val nums = (spelledOutNums + firstDigit + lastDigit).filter { it["index"] != -1 }

    val numIndexes = nums.map { it["index"] ?: -1 }

    val firstNum = nums.first { it["index"] == numIndexes.min() }["num"]
    val lastNum = nums.last { it["index"] == numIndexes.max() }["num"]

    return "$firstNum$lastNum".toInt()
}

fun main() {
    val input = readInput("day01/Day01")
    println(input.sumOf { it.getCalibrationValueWithSpelledOutNum() })
}
