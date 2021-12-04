import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day2Test {

    @Test
    fun testPositionMultiplied() {

        val actual = Day2().positionMultiplied(readLines("day2.txt"))

        assertEquals(150, actual)

    }

    fun readLines(resourceName: String): List<String> {

        val url = object {}::class.java.getResource(resourceName)
        if (url != null) {

            return url.readText().split("\n")

        }

        return listOf()

    }

}