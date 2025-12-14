class StoryTeller {

    private fun randomInt(): Int = (1..50).random()

    fun tellFirstStory(): String {
        val registry = EventRegistry()
        var order = 1

        val garden = Garden("Ogród Jana")
        val customer = Customer(
            name = "Jan",
            loyaltyPoints = 0,
            garden = garden
        )
        garden.setCustomer(customer)

        registry.addEvent(customer.toEvent(order++))

        val flower = Flower("Róża")
        customer.buyPlant(flower)
        registry.addEvent(
            Event(order++, "Jan kupił roślinę: ${flower.name}")
        )

        val petalsToAdd = randomInt()
        repeat(petalsToAdd) {
            flower.addPetal()
        }
        registry.addEvent(
            Event(order++, "Dodano $petalsToAdd płatków do ${flower.name}")
        )

        val petalsToRemove = randomInt()
        repeat(petalsToRemove) {
            flower.deletePetal()
        }
        registry.addEvent(
            Event(order++, "Usunięto $petalsToRemove płatków z ${flower.name}")
        )

        return registry.print()
    }
}

fun Customer.toEvent(order: Int): Event =
    Event(
        order = order,
        message = "Customer $name ma $loyaltyPoints punktów lojalnościowych"
    )
