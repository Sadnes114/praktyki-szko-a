open class Plant(val name: String) {
    var waterLevel: Int = 0
    fun addWater(){
        waterLevel += 1
        println("Water Level: $waterLevel")
    }
    open fun deleteWater(){
        waterLevel -= 1
        println("Water level: $waterLevel")
    }
}