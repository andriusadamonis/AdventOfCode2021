fun main() {

    println("day1    : ${Day1().count(readLines("day1.txt"))}")
    println("day1_2  : ${Day1().countRunning(readLines("day1.txt"))}")
    println("day2    : ${Day2().positionMultiplied(readLines("day2.txt"))}")
    println("day2_2  : ${Day2().positionMultiplied2(readLines("day2.txt"))}")
    println("day3    : ${Day3().powerConsumption(readLines("day3.txt"))}")
    println("day3_2  : ${Day3().lifeSupport(readLines("day3.txt"))}")
    println("day4    : ${Day4().bingoWinning(readLines("day4.txt"))}")
    println("day4_2  : ${Day4().bingoLosing(readLines("day4.txt"))}")
    println("day5    : ${Day5().overlappingPoints(readLines("day5.txt"))}")
    println("day5_2  : ${Day5().overlappingPointsWithDiagonal(readLines("day5.txt"))}")
    println("day6    : ${Day6().day6(readLines("day6.txt"))}")

}

fun readLines(resourceName: String): List<String> {

    val url = object {}::class.java.getResource(resourceName)
    if (url != null) {

        return url.readText().split("\n")

    }

    return listOf()

}