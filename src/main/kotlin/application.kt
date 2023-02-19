import java.io.File

fun main() {
    val elves = parseInput()
    val elvesSortedByHighestCalories = elves.sortedByDescending { it.getAllCalories() }
    val elfWithHighestCalories = elvesSortedByHighestCalories[0]
    val elfWithSecondHighestCalories = elvesSortedByHighestCalories[1]
    val elfWithThirdHighestCalories = elvesSortedByHighestCalories[2]
    val totalTopThreeCalories = elfWithHighestCalories.getAllCalories() + elfWithSecondHighestCalories.getAllCalories() + elfWithThirdHighestCalories.getAllCalories()

    println("--------------------------------------------------------------")
    println("$elfWithHighestCalories\nThis is the elf that carries the most calories with him.\nHe is carrying ${elfWithHighestCalories.getAllCalories()} calories.")
    println("--------------------------------------------------------------")
    println("$elfWithSecondHighestCalories\nThis is the elf that carries the second most calories with him.\nHe is carrying ${elfWithSecondHighestCalories.getAllCalories()} calories.")
    println("--------------------------------------------------------------")
    println("$elfWithThirdHighestCalories\nThis is the elf that carries the most calories with him.\nHe is carrying ${elfWithThirdHighestCalories.getAllCalories()} calories.")
    println("--------------------------------------------------------------")
    println("In total the top three elves carry $totalTopThreeCalories calories.")
    println("--------------------------------------------------------------")
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