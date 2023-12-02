import java.nio.file.Files
import java.nio.file.Paths

data class Game(val id: Int, val red: Int, val green: Int, val blue: Int) {
    constructor(id: Int) : this(id, 0, 0, 0)
}

fun parseGame(gameString: String): Game {
    val gameSplit = gameString.split(":")
    val id = gameSplit.first().replace("Game ", "").toInt()
    return gameSplit[1].split(";")
        .flatMap { eg ->
            eg.split(",")
                .map { findDices(it) }
        }
        .fold(Game(id)) { acc, next ->
            acc.copy(
                red = findGreater(acc.red, next.red),
                green = findGreater(acc.green, next.green),
                blue = findGreater(acc.blue, next.blue)
            )
        }
}

private fun findGreater(acc: Int, next: Int) =
    if (next > acc) next else acc

fun findDices(subset: String): Game {
    val singleDice = subset.split(" ")
    val number = singleDice[1].toInt()
    return when (singleDice[2]) {
        "blue" -> Game(0, 0, 0, number)
        "green" -> Game(0, 0, number, 0)
        "red" -> Game(0, number, 0, 0)
        else -> Game(0, 0, 0, 0)
    }
}

fun isGamePossible(gameString: String): Int {
    val (id, red, green, blue) = parseGame(gameString)
    return if (red <= 12 && green <= 13 && blue <= 14)
        id
    else 0
}

fun sumPossibleIds(games: List<String>): Int =
    games.sumOf { isGamePossible(it) }

fun calculatePower(game: Game): Int =
    game.red*game.green*game.blue

fun calculateFullPower(games:List<String>): Int =
    games.sumOf{calculatePower(parseGame(it))}


fun main() {
    val input = object {}.javaClass.getResource("day2Input.txt")?.toURI()
    val games = Files.readAllLines(input?.let { Paths.get(it) })
    println("sum is: ${sumPossibleIds(games)}")
    println("possible dices is: ${calculateFullPower(games)}")
}
