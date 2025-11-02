class Customer(var name: String, var loyaltyPoints: Int = 0, var garden: Garden? = null) {
    fun buyPlant(plant: Plant) {
        garden?.addPlant(plant)
        loyaltyPoints += 10
    }

    fun buyDecoration(decoration: Decoration) {
        garden?.addDecoration(decoration)
        loyaltyPoints += 5
    }
}