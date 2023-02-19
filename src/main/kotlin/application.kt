import java.io.File

fun main() {
    val elves = parseInput()
    val elfWithMostCalories = elves.maxByOrNull { it.getAllCalories() }
    println("$elfWithMostCalories\nThis is the elf that carries the most calories in the group.\nHe carries ${elfWithMostCalories?.getAllCalories()} calories with him.")
}

private fun parseInput(): List<Elf> {
    val filePath = "src/main/resources/input.txt"
    val caloryList = mutableListOf<Int>()
    val allElves = mutableListOf<Elf>()
    var elfNameCounter = 0

    File(filePath).forEachLine { line ->
        if (line.isNotBlank()) {
            caloryList.add(line.toInt())
        } else {
            elfNameCounter++
            createNewElf(elfNameCounter, allElves, caloryList)
        }
    }

    if (caloryList.isNotEmpty()) {
        elfNameCounter++
        createNewElf(elfNameCounter, allElves, caloryList)
    }

    return allElves
}

private fun createNewElf(elfNameCounter: Int, allElves: MutableList<Elf>, caloryList: MutableList<Int>) {
    val newElfName = "Elf $elfNameCounter"
    allElves.add(Elf(newElfName, caloryList.toList()))
    caloryList.clear()
}