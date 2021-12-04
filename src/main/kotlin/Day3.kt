class Day3 {

    @kotlin.ExperimentalUnsignedTypes
    fun powerConsumption(report: Iterable<UInt>): UInt {

        val gammaRate = gamma(report.map { it.toUInt() })
        val epsilonRate = gammaRate.inv() and 0b11111u

        return gammaRate * epsilonRate

    }

    @kotlin.ExperimentalUnsignedTypes
    fun gamma(report: Iterable<UInt>): UInt {

        val flags = uintArrayOf(1u, 2u, 4u, 8u, 16u);
        var counts0 = IntArray(flags.size) { 0 }
        var counts1 = IntArray(flags.size) { 0 }

        report.forEach {
            flags.forEachIndexed { index, flag ->
                if (it and flag != 0u)
                    counts1[index]++
                else
                    counts0[index]++ }
        }

        var result = 0u
        flags.forEachIndexed { index, flag ->
            if (counts1[index] > counts0[index])
                result = result or flag
        }

        return result

    }

}
