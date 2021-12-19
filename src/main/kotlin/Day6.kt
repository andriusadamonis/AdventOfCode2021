class Day6 {

    fun day6(text: List<String>): Int {

        val fishes = text.get(0).split(',').map { it.toInt() }
        return nextDays(fishes, 80).count()

    }

    fun nextDays(fishes: List<Int>, numberOfDays: Int): List<Int> {
        var list = fishes
        for (d in (1..numberOfDays)) {
            list = nextDay(list)
        }
        return list
    }

    fun nextDay(fishes: List<Int>): List<Int> {
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