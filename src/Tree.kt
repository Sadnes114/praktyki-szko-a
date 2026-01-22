class Tree(name: String): Plant(name) {
    private var leave: Int = 0
    fun addLeave(){
        leave += 1
        println("Leave: $leave")
    }
    fun deleteLeave(){
        leave -= 1
        println("Leave: $leave")
    }

    override fun deleteWater() {
        waterLevel -= 2
        println("Water level: $waterLevel")
    }
}