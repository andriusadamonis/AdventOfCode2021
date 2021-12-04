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

    @Test
    fun testLifeSupport() {

        val actual = Day3().lifeSupport(readLines("day3.txt"))

        assertEquals(230, actual)

    }

    @Test
    fun testOxygen() {

        val actual = Day3().oxygen(readLines("day3.txt"))

        assertEquals("10111", actual)
    }

    @Test
    fun tesCO2Scrubber() {

        val actual = Day3().co2Scrubber(readLines("day3.txt"))

        assertEquals("01010", actual)
    }

}