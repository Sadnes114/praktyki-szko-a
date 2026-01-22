class Garden(val name: String) {
    var plants: List<Plant> = listOf()
    var decorations: List<Decoration> = listOf()
    var customer: Customer? = null

    fun addPlant(plant: Plant) {
        plants = plants + plant
    }
    fun deletePlant(plant: Plant) {
        plants = plants - plant
    }
    fun addDecoration(decoration: Decoration) {
        decorations = decorations + decoration
    }
    fun deleteDecoration(decoration: Decoration) {
        decorations = decorations - decoration
    }
    fun setCustomer(customer: Customer) {
        this.customer = customer
    }


}