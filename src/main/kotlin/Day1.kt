class Day1 {

    fun count(lines: List<String>): Int {

        var count = 0
        lines.forEachIndexed { index, s ->
            if (index > 0 && s.toInt() > lines[index - 1].toInt())
                count++;
        }

        return count;

    }

}