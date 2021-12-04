import java.lang.StringBuilder

class Day3 {

    fun powerConsumption(report: Iterable<String>): Long {

        val gammaRate = gamma(report)
        val epsilonRate = invert(gammaRate)

        return gammaRate.toLong(2) * epsilonRate.toLong(2)

    }

    fun invert(value: String): String {

        var builder = StringBuilder()
        value.forEach {
            builder.append(if (it == '0') '1' else if (it == '1') '0' else it)
        }
        return builder.toString()

    }


    fun gamma(report: Iterable<String>): String {

        data class Cnt(var zeros: Int, var ones: Int)

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

        var result = ""
        counts.forEach {
            result = (if (it.ones > it.zeros) "1" else "0") + result
        }

        return result

    }

}
