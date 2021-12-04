import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day3Test {

    @Test
    fun testInvert() {

        assertEquals("10", Day3().invert("01"))
        assertEquals("", Day3().invert(""))
        assertEquals("1111111", Day3().invert("0000000"))
        assertEquals("aa", Day3().invert("aa"))
    }

    @Test
    fun testPowerConsumption() {

        val actual = Day3().powerConsumption(readLines("day3.txt"))

        assertEquals(198, actual)

    }

    fun readLines(resourceName: String): List<String> {

        val url = object {}::class.java.getResource(resourceName)
        if (url != null) {

            return url.readText().split("\n")

        }

        return listOf()

    }

}