import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.mockito.kotlin.verify
import org.mockito.kotlin.times
import org.junit.jupiter.api.Assertions.assertTrue

class StoryTellerTest {

    @Test
    fun `should tell a consistent story with mocked random values`() {
        val randomGenerator = mock<RandomGenerator>()
        val storyTeller = StoryTeller(randomGenerator)

        whenever(randomGenerator.randomInt()).thenReturn(5, 2)

        val result = storyTeller.tellFirstStory()

        assertTrue(result.contains("Jan"))
        assertTrue(result.contains("Róża"))
        assertTrue(result.contains("Dodano 5"))
        assertTrue(result.contains("Usunięto 2"))

        verify(randomGenerator, times(2)).randomInt()
    }

    @Test
    fun `should call randomInt exactly twice`() {
        val randomGenerator = mock<RandomGenerator>()
        val storyTeller = StoryTeller(randomGenerator)

        whenever(randomGenerator.randomInt()).thenReturn(1)

        storyTeller.tellFirstStory()

        verify(randomGenerator, times(2)).randomInt()
    }

    @Test
    fun `should work for different random values`() {
        val randomGenerator = mock<RandomGenerator>()
        val storyTeller = StoryTeller(randomGenerator)

        whenever(randomGenerator.randomInt()).thenReturn(10, 3)

        val result = storyTeller.tellFirstStory()

        assertTrue(result.contains("Dodano 10"))
        assertTrue(result.contains("Usunięto 3"))
    }
}