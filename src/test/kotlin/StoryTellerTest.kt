import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import kotlin.test.assertTrue

class StoryTellerTest {

    private lateinit var randomGenerator: RandomGenerator
    private lateinit var storyTeller: StoryTeller

    @BeforeEach
    fun setUp() {
        randomGenerator = mock(RandomGenerator::class.java)
        storyTeller = StoryTeller(randomGenerator)
    }

    @Test
    @DisplayName("Powinien wygenerować historię z kontrolowanymi wartościami random")
    fun shouldGenerateStoryWithMockedRandom() {
        // given
        `when`(randomGenerator.randomInt())
            .thenReturn(5) // petalsToAdd
            .thenReturn(2) // petalsToRemove

        // when
        val result = storyTeller.tellFirstStory()

        // then
        assertTrue(result.contains("Jan"))
        assertTrue(result.contains("Róża"))
        assertTrue(result.contains("Dodano 5"))
        assertTrue(result.contains("Usunięto 2"))
    }

    @Test
    @DisplayName("Powinien wywołać randomInt dokładnie 2 razy")
    fun shouldCallRandomIntTwice() {
        // given
        `when`(randomGenerator.randomInt())
            .thenReturn(1)
            .thenReturn(1)

        // when
        storyTeller.tellFirstStory()

        // then
        verify(randomGenerator, times(2)).randomInt()
    }

    @Test
    @DisplayName("Powinien działać dla innych wartości random")
    fun shouldWorkForDifferentValues() {
        // given
        `when`(randomGenerator.randomInt())
            .thenReturn(10)
            .thenReturn(3)

        // when
        val result = storyTeller.tellFirstStory()

        // then
        assertTrue(result.contains("Dodano 10"))
        assertTrue(result.contains("Usunięto 3"))
    }
}