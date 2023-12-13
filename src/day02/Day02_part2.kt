package day02

import readInput

fun main() {
    val input = readInput("day02/Day02")
    val result =
        input.map { it.parseMaxColor() }.map { (it["blue"] ?: 1) * (it["red"] ?: 1) * (it["green"] ?: 1) }.sum()
    println(result)
}