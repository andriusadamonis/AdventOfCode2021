import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day5Test {

    @Test
    fun testDay5() {

        val actual = Day5().overlappingPoints(readLines("day5.txt"))
        val expected = 5

        assertEquals(expected, actual)

    }

    private fun readLines(resourceName: String): List<String> {

        val url = object {}::class.java.getResource(resourceName)
        if (url != null) {

            return url.readText().split("\n")

        }

        return listOf()

    }

}