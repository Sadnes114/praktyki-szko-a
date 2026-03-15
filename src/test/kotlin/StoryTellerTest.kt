import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import kotlin.test.assertEquals

class StoryTellerTest {

    private val randomGenerator = mockk<RandomGenerator>()
    private val storyTeller = StoryTeller(randomGenerator)

    @Test
    fun `should tell a consistent story with mocked random values`() {

        every { randomGenerator.randomInt() } returns 5 andThen 2

        val result = storyTeller.tellFirstStory()

        assertTrue(result.contains("Customer Jan ma 0 punktów lojalnościowych"), "Brak info o kliencie")
        assertTrue(result.contains("Jan kupił roślinę: Róża"), "Brak info o zakupie")
        assertTrue(result.contains("Dodano 5 płatków do Róża"), "Brak info o dodaniu płatków")
        assertTrue(result.contains("Usunięto 2 płatków z Róża"), "Brak info o usunięciu płatków")

        val lines = result.split("\n")
        assertEquals(4, lines.size)
    }
}