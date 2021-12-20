import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class Day6Test {

    @Test
    fun testDay6() {

        val actual = Day6().day6(arrayListOf("3,4,3,1,2"))
        val expected = 5934

        assertEquals(expected, actual)

    }

    @ParameterizedTest
    @CsvSource(value = [
        "3,4,3,1,2|2,3,2,0,1",
        "2,3,2,0,1|1,2,1,6,0,8",
        "1,2,1,6,0,8|0,1,0,5,6,7,8",
        "0,1,0,5,6,7,8|6,0,6,4,5,6,7,8,8",
        "6,0,6,4,5,6,7,8,8|5,6,5,3,4,5,6,7,7,8",
        "5,6,5,3,4,5,6,7,7,8|4,5,4,2,3,4,5,6,6,7",
        "4,5,4,2,3,4,5,6,6,7|3,4,3,1,2,3,4,5,5,6",
        "3,4,3,1,2,3,4,5,5,6|2,3,2,0,1,2,3,4,4,5",
        "2,3,2,0,1,2,3,4,4,5|1,2,1,6,0,1,2,3,3,4,8",
        "1,2,1,6,0,1,2,3,3,4,8|0,1,0,5,6,0,1,2,2,3,7,8",
        "0,1,0,5,6,0,1,2,2,3,7,8|6,0,6,4,5,6,0,1,1,2,6,7,8,8,8",
    ], delimiter = '|')
    fun testOneDay(inputStr: String, expectedStr: String) {

        val input = inputStr.split(',').map { it.toInt() }
        val expected = expectedStr.split(',').map { it.toInt() }.count()

        val actual = Day6().countDays(input, 1)

        assertEquals(expected, actual)

    }

}