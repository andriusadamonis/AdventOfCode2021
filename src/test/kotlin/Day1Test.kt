import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day1Test {

    @Test
    fun testDay1() {

        val actual: Int = Day1().count(readLines("day1.txt"))
        val expected = 7

        assertEquals(expected, actual)

    }


    fun readLines(resourceName: String): List<String> {

        val url = object {}::class.java.getResource(resourceName)
        if (url != null) {

            return url.readText().split("\n")

        }

        return listOf()

    }

}

