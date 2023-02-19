data class Elf (
    val name: String,
    val food: List<Int>
) {
    fun getAllCalories(): Int {
        return this.food.sum()
    }
}