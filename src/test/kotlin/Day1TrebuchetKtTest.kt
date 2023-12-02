import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1TrebuchetKtTest {

    @Test
    fun `1abc2 should return 12`() =
        assertEquals(12, findCalibration("1abc2"))

    @Test
    fun `pqr3stu8vwx should return 38`() =
        assertEquals(38, findCalibration("pqr3stu8vwx"))

    @Test
    fun `a1b2c3d4e5f should return 15`() =
        assertEquals(15, findCalibration("a1b2c3d4e5f"))

    @Test
    fun `treb7uchet should return 77`() =
        assertEquals(77, findCalibration("treb7uchet"))

    @Test
    fun `sum calibration`() {
        val calibrations = listOf(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet"
        )
        assertEquals(142, sumCalibration(calibrations))
    }

    @Test
    fun `sum calibration with numbers written`() {
        val calibrations = listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen"
        )
        assertEquals(281, sumCalibration(calibrations))
    }

    @Test
    fun calibrations() {
        assertEquals(29, findCalibration("two1nine"))
        assertEquals(83, findCalibration("eightwothree"))
        assertEquals(13, findCalibration("abcone2threexyz"))
        assertEquals(24, findCalibration("xtwone3four"))
        assertEquals(42, findCalibration("4nineeightseven2"))
        assertEquals(14, findCalibration("zoneight234"))
        assertEquals(76, findCalibration("7pqrstsixteen"))
    }
}