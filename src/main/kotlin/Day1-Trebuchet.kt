import java.nio.file.Files
import java.nio.file.Paths

fun sumCalibration(calibrations: List<String>): Int =
    calibrations.sumOf { findCalibration(it) }


val digits = mapOf(
    "zero" to 0,
    "0" to 0,
    "one" to 1,
    "1" to 1,
    "two" to 2,
    "2" to 2,
    "three" to 3,
    "3" to 3,
    "four" to 4,
    "4" to "4",
    "five" to 5,
    "5" to 5,
    "six" to 6,
    "6" to 6,
    "seven" to 7,
    "7" to 7,
    "eight" to 8,
    "8" to 8,
    "nine" to 9,
    "9" to 9
)

fun findCalibration(line: String): Int {
    val first = digits[line.findAnyOf(digits.keys)?.second]
    val second = digits[line.findLastAnyOf(digits.keys)?.second]
    return "$first$second".toInt()
}
fun main() {
    val input = object {}.javaClass.getResource("day1Input.txt")?.toURI()
    println(sumCalibration(Files.readAllLines(input?.let { Paths.get(it) })))

}

