import kotlin.math.abs
import kotlin.math.min
import kotlin.math.max

class Day5 {

    data class Point(val x: Int, val y: Int)
    data class Line(val from: Point, val to: Point)

    fun overlappingPoints(text: List<String>): Int {

        return overlappingLines(readLines(text), this::pointOnLine)

    }

    private fun between(value: Int, from: Int, to: Int): Boolean {
        if (from <= to)
            return from <= value && value <= to
        else
            return to <= value && value <= from
    }

    private fun sign(value: Int): Int {
        if (value < 0) return -1
        else if (value == 0) return 0
        else return 1
    }

    fun pointOnLine(line: Line, point: Point): Boolean {
        return line.from.x == point.x && line.to.x == point.x && between(point.y, line.from.y, line.to.y) ||
               line.from.y == point.y && line.to.y == point.y && between(point.x, line.from.x, line.to.x)
    }

    fun pointOnDiagonal(line: Line, point: Point): Boolean {
        return line.from.x == point.x && line.to.x == point.x && between(point.y, line.from.y, line.to.y) ||
               line.from.y == point.y && line.to.y == point.y && between(point.x, line.from.x, line.to.x) ||
                abs(line.from.x - line.to.x) == abs(line.from.y - line.to.y) && (
                line.from.x == point.x && line.from.y == point.y ||
                line.to.x == point.x && line.to.y == point.y ||
                        between(point.y, line.from.y, line.to.y) &&
                        between(point.x, line.from.x, line.to.x) &&
                        abs(point.x - line.from.x) == abs(point.y - line.from.y) &&
                        sign(point.x - line.from.x) == sign(line.to.x - line.from.x) &&
                        sign(point.y - line.from.y) == sign(line.to.y - line.from.y)
                )
    }


    fun overlappingPointsWithDiagonal(text: List<String>): Int {

        return overlappingLines(readLines(text), this::pointOnDiagonal)

    }

    fun overlappingLines(lines: List<Line>, predicate: (line: Line, point: Point) -> Boolean): Int {

        val minX = lines.minOf { min(it.from.x, it.to.x) }
        val minY = lines.minOf { min(it.from.y, it.to.y) }
        val maxX = lines.maxOf { max(it.from.x, it.to.x) }
        val maxY = lines.maxOf { max(it.from.y, it.to.y) }

        var result = 0

        for (y in minY..maxY) {

            // print(String.format("%${maxY.toString().length}d: ", y))

            for (x in minX..maxX) {

                val cnt = lines.count {
                    predicate(it, Point(x, y))
                }
                if (cnt > 1)
                    result++

                // print(if (cnt > 9) "#" else if (cnt == 0) "." else cnt)

            }
            // println("")
        }
        return result
    }

    fun readLines(textLines: List<String>): List<Line> {
        return textLines.map {
            val itt = it.split("->")
            val f = itt.get(0).trim().split(',').map { it.toInt() }
            val t = itt.get(1).trim().split(',').map { it.toInt() }
            Line(Point(f[0], f[1]), Point(t[0], t[1]))
        }
    }

}