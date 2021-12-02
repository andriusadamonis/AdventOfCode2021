class Day1 {

    fun count(lines: List<String>): Int {

        return countGrowing(lines.map { it.toInt() })

    }

    fun countRunning(lines: List<String>): Int {

        return countRunningTotalsOf5(lines.map { it.toInt() })

    }

    fun countGrowing(measurements: Iterable<Int>): Int {

        var count = 0
        var prev: Int? = null;
        measurements.forEach { it ->
            if (prev != null && it > prev!!)
                count++;
            prev = it;
        }

        return count;

    }

    fun countRunningTotalsOf5(measurements: Iterable<Int>): Int {

        return countGrowing(aggregateRunningTotalsOf5(measurements))

    }

    fun aggregateRunningTotalsOf5(measurements: Iterable<Int>): Iterable<Int> {

        var result = mutableListOf<Int>()

        var prev2: Int? = null
        var prev1: Int? = null
        for (measurement in measurements) {
            if (prev2 != null && prev1 != null)
                result += prev2 + prev1 + measurement
            prev2 = prev1
            prev1 = measurement
        }

        return result

    }

}