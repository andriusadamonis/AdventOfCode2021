class Day2 {

    data class Pos(var horizontal: Int, var depth: Int)

    fun positionMultiplied(instructions: Iterable<String>): Int {

        val position = calculatePosition(instructions)
        return position.horizontal * position.depth;

    }

    private fun calculatePosition(instructions: Iterable<String>): Pos {
        var result: Pos = Pos(0, 0)
        instructions.forEach() {
            val instruction = it.split(" ")
            if (instruction.size >= 2) {
                when (instruction[0]) {
                    "forward" -> result.horizontal += instruction[1].toInt()
                    "down" -> result.depth += instruction[1].toInt()
                    "up" -> result.depth -= instruction[1].toInt()
                }
            }
        }

        return result

    }

}