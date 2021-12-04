import java.lang.StringBuilder

class Day3 {

    fun powerConsumption(report: List<String>): Long {

        val gammaRate = gamma(report)
        val epsilonRate = invert(gammaRate)

        return gammaRate.toLong(2) * epsilonRate.toLong(2)

    }

    fun lifeSupport(report: List<String>): Long {

        val oxygenRating = oxygen(report)
        val co2ScrubberReport = co2Scrubber(report)

        return oxygenRating.toLong(2) * co2ScrubberReport.toLong(2)

    }


    fun invert(value: String): String {

        var builder = StringBuilder()
        value.forEach {
            builder.append(if (it == '0') '1' else if (it == '1') '0' else it)
        }
        return builder.toString()

    }


    data class Cnt(var zeros: Int, var ones: Int)

    fun countBits(report: Iterable<String>): List<Cnt> {

        var counts = mutableListOf<Cnt>()

        report.forEach {
            it.reversed().forEachIndexed() { index, ch ->
                while (counts.size <= index) counts.add(Cnt(0, 0))
                if (ch == '0')
                    counts[index].zeros++
                else if (ch == '1')
                    counts[index].ones++
            }
        }

        return counts
    }

    fun gamma(report: Iterable<String>): String {

        var result = ""
        countBits(report).forEach {
            result = (if (it.ones > it.zeros) "1" else "0") + result
        }

        return result

    }

    fun search(report: List<String>, condition: (zeros: Int, ones: Int) -> String): String {

        var current = report
        var bits = countBits(current).reversed()
        var p = -1
        while (++p < bits.size && current.size > 1) {
            val bit = condition(bits[p].zeros, bits[p].ones)
            current = current.filter { it.substring(p, p + 1).equals(bit) }
            bits = countBits(current).reversed()
        }
        if (current.size > 0)
            return current.get(0)
        else
            return CharArray(bits.size) { '0' }.joinToString("")
    }

    fun oxygen(report: List<String>): String {
        return search(report) { zeros, ones -> if (zeros <= ones) "1" else "0"}
    }

    fun co2Scrubber(report: List<String>): String {
        return search(report) { zeros, ones -> if (zeros <= ones) "0" else "1"}
    }

}