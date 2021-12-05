import kotlin.math.min
import kotlin.math.max

class Day5 {

    data class Point(val x: Int, val y: Int)
    data class Line(val from: Point, val to: Point)

    fun overlappingPoints(text: List<String>): Int {

        val lines = readLines(text)
        val minX = lines.minOf { min(it.from.x, it.to.x) }
        val minY = lines.minOf { min(it.from.y, it.to.y) }
        val maxX = lines.maxOf { max(it.from.x, it.to.x) }
        val maxY = lines.maxOf { max(it.from.y, it.to.y) }

        var result = 0

        for (x in minX..maxX)
            for (y in minY..maxY) {

                val cnt = lines.count {
                        it.from.x == x && it.to.x == x && it.from.y <= y && y <= it.to.y ||
                        it.from.y == y && it.to.y == y && it.from.x <= x && x <= it.to.x
                    }
                if (cnt > 1)
                    result++

            }

        return result
    }

    fun readLines(textLines: List<String>): List<Line> {
        return textLines.map {
            val itt = it.split("->")
            val f = itt.get(0).trim().split(',').map { it.toInt() }
            val t = itt.get(1).trim().split(',').map { it.toInt() }
            Line(Point(min(f[0], t[0]), min(f[1], t[1])), Point(max(f[0], t[0]), max(f[1], t[1]))) // mind start/end
        }
    }

}