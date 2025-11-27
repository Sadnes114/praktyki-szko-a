class StoryTeller {
    fun createStory(): List<EventRegistry> {
        val events = listOf(
            EventRegistry("Start", "Początek historii"),
            EventRegistry("Middle", "Rozwinięcie akcji"),
            EventRegistry("End", "Zakończenie")
        )
        return events
    }
}