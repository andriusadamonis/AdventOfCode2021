import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day4Test {

    @Test
    fun testBingoWinner() {

        val actual = Day4().bingoWinning(readLines("day4.txt"))

        assertEquals(4512, actual)

    }

    @Test
    fun testBingoLoser() {

        val actual = Day4().bingoLosing(readLines("day4.txt"))

        assertEquals(1924, actual)

    }

    private fun readLines(resourceName: String): List<String> {

        val url = object {}::class.java.getResource(resourceName)
        if (url != null) {

            return url.readText().split("\n")

        }

        return listOf()

    }

}