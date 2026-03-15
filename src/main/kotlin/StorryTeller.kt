class StoryTeller(private val randomGenerator: RandomGenerator) {


    fun tellFirstStory(): String {
        val registry = EventRegistry()
        var order = 1

        val garden = Garden("Ogród Jana")
        val customer = Customer(
            name = "Jan",
            loyaltyPoints = 0,
            garden = garden
        )
        garden.customer = customer

        registry.addEvent(event = customer.toEvent(order++))

        val flower = Flower(name = "Róża")
        customer.buyPlant(plant = flower)
        registry.addEvent(
            Event(order++, message = "Jan kupił roślinę: ${flower.name}")
        )

        val petalsToAdd = randomGenerator.randomInt()
        flower.addPetals(petalsToAdd)

        registry.addEvent(
            Event(order++, message = "Dodano $petalsToAdd płatków do ${flower.name}")
        )

        val petalsToRemove = randomGenerator.randomInt()
        flower.deletePetals(petalsToRemove)

        registry.addEvent(
            Event(order++, message = "Usunięto $petalsToRemove płatków z ${flower.name}")
        )

        return registry.print()
    }
}

fun Customer.toEvent(order: Int): Event =
    Event(
        order = order,
        message = "Customer $name ma $loyaltyPoints punktów lojalnościowych"
    )
