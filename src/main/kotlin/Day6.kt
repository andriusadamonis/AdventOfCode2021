class Day6 {

    fun day6(text: List<String>, numberOfDays: Int): Int {

        val fishes = text.get(0).split(',').map { it.toInt() }
        return countDays(fishes, numberOfDays)

    }

    fun countDays(fishes: Iterable<Int>, numberOfDays: Int): Int {

        var list = fishes
        for (d in (1..numberOfDays)) {
            list = nextDay(list)
        }
        return list.count()
    }

    fun nextDay(fishes: Iterable<Int>): Iterable<Int> {
        val list = mutableListOf<Int>()
        val new = mutableListOf<Int>()
        fishes.forEach {
            if (it == 0) {
                list.add(6)
                new.add(8)
            }
            else {
                list.add(it - 1)
            }
        }
        list.addAll(new)

        return list

    }

}