class Flower(name: String) : Plant(name) {

    private var petal: Int = 0

    fun addPetals(amount: Int) {
        repeat(amount) {
            petal += amount
            println("Petal: $petal")
        }
    }

    fun deletePetals(amount: Int) {
        repeat(amount) {
            petal -= amount
            println("Petal: $petal")
        }
    }
}