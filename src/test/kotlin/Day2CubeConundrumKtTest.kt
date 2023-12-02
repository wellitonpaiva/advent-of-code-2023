import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day2CubeConundrumKtTest {

    @Test
    fun `can parse game 1`() = assertEquals(
        Game(1, 4, 2, 6),
        parseGame("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
    )

    @Test
    fun `power of game 1 is 48`() {
        assertEquals(48, calculatePower(Game(1, 4, 2, 6)))
    }

    @Test
    fun `can parse game 2`() = assertEquals(
        Game(2, 1, 3, 4),
        parseGame("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue")
    )

    @Test
    fun `can parse game 3`() = assertEquals(
        Game(3, 20, 13, 6),
        parseGame("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red")
    )

    @Test
    fun `game 3 is not possible`() {
        assertEquals(0, isGamePossible("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"))
    }

    @Test
    fun `iteration 1 is possible`() {
        val games = listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        )
        assertEquals(8, sumPossibleIds(games))
    }
}