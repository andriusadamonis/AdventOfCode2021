fun main() {

    println("day1    : ${Day1().count(readLines("day1.txt"))}")
    println("day1_2  : ${Day1().countRunning(readLines("day1.txt"))}")

}

fun readLines(resourceName: String): List<String> {

    val url = object {}::class.java.getResource(resourceName)
    if (url != null) {

        return url.readText().split("\n")

    }

    return listOf()

}