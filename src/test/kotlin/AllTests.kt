import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AllTests {

        @Test
        fun `addWater should increase water level`() {
            val plant = Plant("Rose")

            plant.addWater()

            assertEquals(1, plant.waterLevel)
        }

        @Test
        fun `deleteWater should decrease water level`() {
            val plant = Plant("Tulip")
            plant.addWater()

            plant.deleteWater()

            assertEquals(0, plant.waterLevel)
        }

        @Test
        fun `randomInt should return number between 1 and 50`() {
            val generator = RandomGenerator()

            val result = generator.randomInt()

            assertTrue(result in 1..50)
        }

        @Test
        fun `clean should not throw exception`() {
            val decoration = Decoration("Lamp")

            decoration.getDirty()

            assertDoesNotThrow {
                decoration.clean()
            }
        }

        @Test
        fun `getDirty should not throw exception`() {
            val decoration = Decoration("Bench")

            assertDoesNotThrow {
                decoration.getDirty()
            }
        }

        @Test
        fun `buyPlant should add loyalty points`() {
            val customer = Customer("Jan")
            val plant = Plant("Rose")

            customer.buyPlant(plant)

            assertEquals(10, customer.loyaltyPoints)
        }

        @Test
        fun `buyDecoration should add loyalty points`() {
            val customer = Customer("Anna")
            val decoration = Decoration("Fountain")

            customer.buyDecoration(decoration)

            assertEquals(5, customer.loyaltyPoints)
        }

        @Test
        fun `should contain initial event`() {
            val registry = EventRegistry()

            val result = registry.print()

            assertTrue(result.contains("Rozpoczęcie historii"))
        }

        @Test
        fun `should sort events by order`() {
            val registry = EventRegistry()

            registry.addEvent(Event(2, "Koniec"))
            registry.addEvent(Event(1, "Środek"))

            val result = registry.print()

            val lines = result.lines()

            assertEquals("Rozpoczęcie historii", lines[0])
            assertEquals("Środek", lines[1])
            assertEquals("Koniec", lines[2])
        }
    }

