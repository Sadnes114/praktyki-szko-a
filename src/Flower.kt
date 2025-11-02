class Flower(name: String): Plant(name) {
    private var petal: Int = 0
    fun addPetal() {
        petal += 1
        println("Petal: $petal")
    }
    fun deletePetal() {
        petal -= 1
        println("Petal: $petal")
    }
}