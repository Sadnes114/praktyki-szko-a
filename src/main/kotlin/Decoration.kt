class Decoration(val name: String) {
    private var condition: Condition = Condition.CLEAN


    fun clean(){
        condition = Condition.CLEAN
        println("Cleaning $name")
    }
    fun getDirty(){
        condition = if (condition == Condition.DIRTY || condition == Condition.VERY_DIRTY){
            Condition.VERY_DIRTY
        } else {
            Condition.DIRTY
        }
        println("current: $condition")
    }
}