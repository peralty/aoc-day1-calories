import java.io.File

fun main() {

    val elves = parseInput()

    elves.forEach { elf ->
        println("$elf \n")
    }

}

/***
 * Parses Input Textfile and creates elf objects with lists of calories
 */
private fun parseInput(): List<Elf> {
    val filePath = "src/main/resources/input.txt"
    var caloryList = mutableListOf<Int>()
    var allElves = mutableListOf<Elf>()
    var elfNameCounter = 0

    File(filePath).forEachLine { line ->
        if (!(line.isBlank())) {
            caloryList.add(line.toInt())
        } else {
            createNewElf(elfNameCounter, allElves, caloryList)
        }
    }

    if (caloryList.isNotEmpty()) {
        createNewElf(elfNameCounter, allElves, caloryList)
    }

    return allElves
}

private fun createNewElf(elfNameCounter: Int, allElves: MutableList<Elf>, caloryList: MutableList<Int>): Int {
    val newElfName = "Elf ${elfNameCounter + 1}"
    allElves.add(Elf(newElfName, caloryList.toList()))
    caloryList.clear()
    return elfNameCounter + 1
}