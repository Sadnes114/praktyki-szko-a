data class EventRegistry(
    private val events: MutableList<Event> = mutableListOf(
        Event(
            order = 0,
            message = "Rozpoczęcie historii"
        )
    )
) {


    fun addEvent(event: Event) {
        events.add(event)
    }


    fun print(): String =
        events
            .sortedBy { it.order }
            .joinToString(separator = "\n") { it.message }
}