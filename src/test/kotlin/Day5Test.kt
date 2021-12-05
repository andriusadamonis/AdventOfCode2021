import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day5Test {

    @Test
    fun testDay5() {

        val actual = Day5().overlappingPoints(readLines("day5.txt"))
        val expected = 5

        assertEquals(expected, actual)

    }

    @Test
    fun testDay5part2() {

        val actual = Day5().overlappingPointsWithDiagonal(readLines("day5.txt"))
        val expected = 12

        assertEquals(expected, actual)

    }

    @Test
    fun testPointOnLine() {

        assertTrue(Day5().pointOnLine(Day5.Line(Day5.Point(1, 1), Day5.Point(1, 2)), Day5.Point(1, 1)))
        assertTrue(Day5().pointOnLine(Day5.Line(Day5.Point(1, 1), Day5.Point(1, 2)), Day5.Point(1, 2)))

        assertTrue(Day5().pointOnLine(Day5.Line(Day5.Point(2, 2), Day5.Point(1, 2)), Day5.Point(2, 2)))

        assertFalse(Day5().pointOnLine(Day5.Line(Day5.Point(1, 1), Day5.Point(2, 2)), Day5.Point(1, 1)))

    }

    @Test
    fun testPointOnDiagonal() {
/*
        assertTrue(Day5().pointOnDiagonal(Day5.Line(Day5.Point(1, 1), Day5.Point(1, 2)), Day5.Point(1, 1)), "1")
        assertTrue(Day5().pointOnDiagonal(Day5.Line(Day5.Point(1, 1), Day5.Point(1, 2)), Day5.Point(1, 2)), "2")
        assertTrue(Day5().pointOnDiagonal(Day5.Line(Day5.Point(2, 2), Day5.Point(1, 2)), Day5.Point(2, 2)), "3")
        assertTrue(Day5().pointOnDiagonal(Day5.Line(Day5.Point(10, 10), Day5.Point(10, 2)), Day5.Point(10, 5)), "4")
*/
        assertTrue(Day5().pointOnDiagonal(Day5.Line(Day5.Point(2, 2), Day5.Point(10, 10)), Day5.Point(2, 2)), "5")
        assertTrue(Day5().pointOnDiagonal(Day5.Line(Day5.Point(2, 2), Day5.Point(10, 10)), Day5.Point(10, 10)), "6")
        assertTrue(Day5().pointOnDiagonal(Day5.Line(Day5.Point(2, 2), Day5.Point(10, 10)), Day5.Point(5, 5)), "7")
        assertFalse(Day5().pointOnDiagonal(Day5.Line(Day5.Point(2, 2), Day5.Point(10, 10)), Day5.Point(1, 1)), "8")

        assertTrue(Day5().pointOnDiagonal(Day5.Line(Day5.Point(2, 10), Day5.Point(10, 2)), Day5.Point(2, 10)), "9")
        assertTrue(Day5().pointOnDiagonal(Day5.Line(Day5.Point(2, 10), Day5.Point(10, 2)), Day5.Point(10, 2)), "10")
        assertTrue(Day5().pointOnDiagonal(Day5.Line(Day5.Point(2, 10), Day5.Point(10, 2)), Day5.Point(6, 6)), "11")
        assertFalse(Day5().pointOnDiagonal(Day5.Line(Day5.Point(2, 10), Day5.Point(10, 2)), Day5.Point(1, 9)), "12")
        assertFalse(Day5().pointOnDiagonal(Day5.Line(Day5.Point(2, 10), Day5.Point(10, 2)), Day5.Point(9, 1)), "13")

    }

    @Test
    fun testPointOnDiagonal2() {

        assertEquals(0, Day5().overlappingPointsWithDiagonal(listOf("1,1 -> 1,1")))
        assertEquals(1, Day5().overlappingPointsWithDiagonal(listOf("1,1 -> 1,1", "1,1 -> 1,1")))

        assertEquals(1, Day5().overlappingPointsWithDiagonal(listOf("1,1 -> 5,5", "1,1 -> 1,1")))
        assertEquals(1, Day5().overlappingPointsWithDiagonal(listOf("1,1 -> 5,5", "1,1 -> 5,1", "1,1 -> 1,5")))
        assertEquals(1, Day5().overlappingPointsWithDiagonal(listOf("1,1 -> 5,5", "1,5 -> 5,1")))
        assertEquals(1, Day5().overlappingPointsWithDiagonal(listOf("5,5 -> 1,1", "1,5 -> 5,1")))
        assertEquals(1, Day5().overlappingPointsWithDiagonal(listOf("5,5 -> 1,1", "5,1 -> 1,5")))

        assertEquals(0, Day5().overlappingPointsWithDiagonal(listOf("1,1 -> 3,3", "1,2 -> 3,4")))

        assertEquals(2, Day5().overlappingPointsWithDiagonal(listOf("1,1 -> 3,3", "1,2 -> 3,4", "1,2 -> 4,2")))
        assertEquals(2, Day5().overlappingPointsWithDiagonal(listOf("3,3 -> 1,1", "1,2 -> 3,4", "1,2 -> 4,2")))
        assertEquals(2, Day5().overlappingPointsWithDiagonal(listOf("3,3 -> 1,1", "1,2 -> 3,4", "4,2 -> 1,2")))

        assertEquals(1, Day5().overlappingPointsWithDiagonal(listOf("5,5 -> 1,1", "5,1 -> 1,5", "1,3 -> 5,3")))
        assertEquals(1, Day5().overlappingPointsWithDiagonal(listOf("5,5 -> 1,1", "5,1 -> 1,5", "3,1 -> 3,5")))
        assertEquals(3, Day5().overlappingPointsWithDiagonal(listOf("5,5 -> 1,1", "5,1 -> 1,5", "1,5 -> 5,5")))

        assertEquals(0, Day5().overlappingPointsWithDiagonal(listOf("4,4 -> 1,1", "4,1 -> 1,4")))
        assertEquals(2, Day5().overlappingPointsWithDiagonal(listOf("4,4 -> 1,1", "4,1 -> 1,4", "3,4 -> 3,1")))
        assertEquals(4, Day5().overlappingPointsWithDiagonal(listOf("4,4 -> 1,1", "4,1 -> 1,4", "3,4 -> 3,1", "4,3 -> 1,3", "1,2 -> 4,2", "2,1->2,4")))
        assertEquals(0, Day5().overlappingPointsWithDiagonal(listOf("1,1 -> 1,6", "2,1 -> 6,1", "5,3 -> 3,5")))
        assertEquals(0, Day5().overlappingPointsWithDiagonal(listOf("1,1 -> 1,6", "2,1 -> 6,1", "3,3 -> 4,4")))
        assertEquals(4, Day5().overlappingPointsWithDiagonal(listOf("4,4 -> 1,1", "4,1 -> 1,4", "3,4 -> 3,1", "4,3 -> 1,3", "1,2 -> 4,2", "2,1->2,4", "2,2 -> 3,3")))

    }

    private fun readLines(resourceName: String): List<String> {

        val url = object {}::class.java.getResource(resourceName)
        if (url != null) {

            return url.readText().split("\n")

        }

        return listOf()

    }

}