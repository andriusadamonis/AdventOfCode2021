import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class Day2Test {

    @Test
    fun testPositionMultiplied() {

        val actual = Day2().positionMultiplied(readLines("day2.txt"))

        assertEquals(150, actual)

    }

    @Test
    fun testPositionMultipliedCommandError() {

        val input = listOf("blabla 1", "down 1")
        val exception = assertFailsWith<NotImplementedError>() { Day2().calculatePosition(input) }
        assertEquals("Error in command #1: Not implemented: \"blabla\"", exception.message)

    }

    @Test
    fun testPositionMultipliedParseError() {

        val input = listOf("forward 1", "down xxx")
        val exception = assertFailsWith<NumberFormatException>() { Day2().calculatePosition(input) }
        assertEquals("Error in command #2: For input string: \"xxx\"", exception.message)

    }

    fun readLines(resourceName: String): List<String> {

        val url = object {}::class.java.getResource(resourceName)
        if (url != null) {

            return url.readText().split("\n")

        }

        return listOf()

    }

}