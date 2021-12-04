import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day3Test {

    @Test
    fun testPowerConsumption() {

        val actual = Day3().powerConsumption(readLines("day3.txt").map { it.toUInt() })

        assertEquals(198u, actual)

    }

    fun readLines(resourceName: String): List<String> {

        val url = object {}::class.java.getResource(resourceName)
        if (url != null) {

            return url.readText().split("\n")

        }

        return listOf()

    }

}