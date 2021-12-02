import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

internal class Day1Test {

    @Test
    fun testDay1() {

        val actual: Int = Day1().count(readLines("day1.txt"))
        val expected = 7

        assertEquals(expected, actual)

    }

    @Test
    fun testDay1part2() {

        val actual: Int = Day1().countRunning(readLines("day1.txt"))
        val expected = 5

        assertEquals(expected, actual)

    }

    @Test
    fun testGrowing() {

        assertEquals(1, Day1().countGrowing(arrayListOf<Int>(1, 2)))
        assertEquals(1, Day1().countGrowing(arrayListOf<Int>(1, 2, 1)))
        assertEquals(2, Day1().countGrowing(arrayListOf<Int>(1, 2, 1, 2)))

    }

    @Test
    fun testAggregate() {

        assertContentEquals(listOf<Int>(), Day1().aggregateRunningTotalsOf5(listOf<Int>()))
        assertContentEquals(listOf<Int>(), Day1().aggregateRunningTotalsOf5(listOf<Int>(1)))
        assertContentEquals(listOf<Int>(), Day1().aggregateRunningTotalsOf5(listOf<Int>(1, 2)))
        assertContentEquals(listOf<Int>(6), Day1().aggregateRunningTotalsOf5(listOf<Int>(1, 2, 3)))
        assertContentEquals(listOf<Int>(6, 9, 12), Day1().aggregateRunningTotalsOf5(listOf<Int>(1, 2, 3, 4, 5)))

    }

    fun readLines(resourceName: String): List<String> {

        val url = object {}::class.java.getResource(resourceName)
        if (url != null) {

            return url.readText().split("\n")

        }

        return listOf()

    }

}

