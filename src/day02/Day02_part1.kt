package day02

import readInput

fun String.parseMaxColor(): Map<String, Int> {
    val parsedStr = this.split(": ", "; ")

    val mapped = mutableMapOf(
        "game" to parsedStr[0].split(" ")[1].toInt(),
        "blue" to 0,
        "red" to 0,
        "green" to 0
    )

    for ((index, item) in parsedStr.withIndex()) {
        if (index == 0) continue
        val parsedItem = item.split(", ")
        for (j in parsedItem) {
            val (num, color) = j.split(" ")
            if (color == "blue" && (mapped["blue"] ?: 0) < num.toInt()) mapped["blue"] = num.toInt()
            if (color == "red" && (mapped["red"] ?: 0) < num.toInt()) mapped["red"] = num.toInt()
            if (color == "green" && (mapped["green"] ?: 0) < num.toInt()) mapped["green"] = num.toInt()
        }
    }
    return mapped
}

fun main() {
    val input = readInput("day02/Day02")
    val parsedInput = input.map { it.parseMaxColor() }

    val result = parsedInput.filter { (it["red"] ?: 0) <= 12 && (it["green"] ?: 0) <= 13 && (it["blue"] ?: 0) <= 14 }
        .sumOf { it["game"] ?: 0 }
    println(result)
}
