data class Elf (
    val name: String,
    val food: List<Int>
) {
    fun getAllCalories(): Int {
        var allCalories: Int = 0
        this.food.forEach { foodItem ->
            allCalories += foodItem
        }
        return allCalories
    }
}